import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class ExcluirCadastro extends JFrame {

    private final JTextField idTextField = new JTextField();
    private final JTextField nomeTextField = new JTextField();
    private final JTextField emailTextField = new JTextField();
    private final JPasswordField senhaTextField = new JPasswordField();
    private final JLabel idJLabel = new JLabel("ID:");
    private final JLabel nomeJLabel = new JLabel("Digite o nome:");
    private final JLabel emailJLabel = new JLabel("Digite o email:");
    private final JLabel senhaJLabel = new JLabel("Digite a senha:");
    private final JButton primeiroRegistroJButton = new JButton("<<");
    private final JButton registroAnteriorJButton = new JButton("<");
    private final JButton proximoRegistroJButton = new JButton(">");
    private final JButton ultimoRegistroJButton = new JButton(">>");
    private final JButton deletarRegistroJButton = new JButton("Deletar");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");

    public ExcluirCadastro() {
        super("Excluir Cadastro");
        setLayout(new GridLayout(6, 4, 5, 5));

        add(idJLabel);
        add(idTextField);
        add(deletarRegistroJButton);
        deletarRegistroJButton.setToolTipText("Deletar cadastro");
        add(new JLabel());

        add(nomeJLabel);
        add(nomeTextField);
        add(new JLabel());
        add(new JLabel());

        add(emailJLabel);
        add(emailTextField);
        add(new JLabel());
        add(new JLabel());

        add(senhaJLabel);
        add(senhaTextField);
        add(new JLabel());
        add(new JLabel());

        idTextField.setEnabled(false);

        nomeTextField.setEditable(false);
        emailTextField.setEditable(false);
        senhaTextField.setEditable(false);



        add(primeiroRegistroJButton);
        primeiroRegistroJButton.setToolTipText("Primeiro registro");
        add(registroAnteriorJButton);
        registroAnteriorJButton.setToolTipText("Registro anterior");
        add(proximoRegistroJButton);
        proximoRegistroJButton.setToolTipText("Próximo registro");
        add(ultimoRegistroJButton);
        ultimoRegistroJButton.setToolTipText("Último registro");
        add(notificacaoJLabel);

        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        carregarPrimeiroRegistro();

        primeiroRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                carregarPrimeiroRegistro();
            }
        });

        ultimoRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                carregarUltimoRegistro();
            }
        });

        registroAnteriorJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                carregarRegistroAnterior();
            }
        });

        proximoRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                carregarProximoRegistro();
            }
        });

        deletarRegistroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                deletarRegistro();
            }
        });

        KeyAdapter keyAdapter = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            }
        };

        nomeTextField.addKeyListener(keyAdapter);
        emailTextField.addKeyListener(keyAdapter);
        senhaTextField.addKeyListener(keyAdapter);

    }

    private void carregarPrimeiroRegistro() {
        String[] resultado;
        try {
            resultado = NavegadorDeRegistro.primeiroRegistro("db_teste", "tbl_teste");
            notificacaoJLabel.setText("Primeiro registro posicionado com sucesso");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarBotoes(resultado[0]);
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o primeiro. Veja o erro: " + e);
        }
    }

    private void carregarUltimoRegistro() {
        String[] resultado;
        try {
            resultado = NavegadorDeRegistro.ultimoRegistro("db_teste", "tbl_teste");
            notificacaoJLabel.setText("Último registro posicionado com sucesso");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarBotoes(resultado[0]);
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro para o último. Veja o erro: " + e);
        }
    }

    private void carregarRegistroAnterior() {
        String[] resultado;
        try {
            resultado = NavegadorDeRegistro.registroAnterior("db_teste", "tbl_teste", idTextField.getText());
            notificacaoJLabel.setText("Registro anterior posicionado com sucesso");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarBotoes(resultado[0]);
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu algum erro ao posicionar o registro anterior. Veja o erro: " + e);
        }
    }

    private void carregarProximoRegistro() {
        String[] resultado;
        try {
            resultado = NavegadorDeRegistro.proximoRegistro("db_teste", "tbl_teste", idTextField.getText());
            notificacaoJLabel.setText("Próximo registro posicionado com sucesso");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarBotoes(resultado[0]);
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu algum erro ao posicionar o próximo registro. Veja o erro: " + e);
        }
    }

    private void deletarRegistro() {
        try {
            NavegadorDeRegistro.deletarRegistro("db_teste", "tbl_teste", idTextField.getText());
            notificacaoJLabel.setText("Registro deletado com sucesso");
            carregarPrimeiroRegistro();
        } catch (Exception e) {
            System.out.println("Erro ao deletar o registro: " + e);
        }
    }

    private void atualizarBotoes(String idAtual) {
        try {
            boolean primeiroRegistro = NavegadorDeRegistro.isPrimeiroRegistro("db_teste", "tbl_teste", idAtual);
            boolean ultimoRegistro = NavegadorDeRegistro.isUltimoRegistro("db_teste", "tbl_teste", idAtual);

            primeiroRegistroJButton.setEnabled(!primeiroRegistro);
            registroAnteriorJButton.setEnabled(!primeiroRegistro);
            proximoRegistroJButton.setEnabled(!ultimoRegistro);
            ultimoRegistroJButton.setEnabled(!ultimoRegistro);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar os botões: " + e);
        }
    }

    public static void main(String[] args) {
        new ExcluirCadastro();
    }
}
