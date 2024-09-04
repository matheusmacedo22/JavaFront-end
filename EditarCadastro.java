import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditarCadastro extends JFrame {

    private final JTextField idTextField = new JTextField();
    private final JTextField nomeTextField = new JTextField();
    private final JTextField emailTextField = new JTextField();
    private final JPasswordField senhaTextField = new JPasswordField();
    private final JLabel idJLabel = new JLabel("ID:");
    private final JLabel nomeJLabel = new JLabel("Digite o nome:");
    private final JLabel emailJLabel = new JLabel("Digite o email:");
    private final JLabel senhaJLabel = new JLabel("Digite a senha:");
    private final JButton atualizarJButton = new JButton("✓");
    private final JButton primeiroRegistroJButton = new JButton("<<");
    private final JButton registroAnteriorJButton = new JButton("<");
    private final JButton proximoRegistroJButton = new JButton(">");
    private final JButton ultimoRegistroJButton = new JButton(">>");
    private final JButton deletarRegistroJButton = new JButton("Deletar");
    private final JLabel notificacaoJLabel = new JLabel("Notificações...");
    private final JButton adicionarNovoCadastroJButton = new JButton("Cadastrar");
    private final JButton limparCamposJButton = new JButton("Limpar");
    private final JButton pesquisarJButton = new JButton("🔍");

    public EditarCadastro() {
        super("Editar Cadastro");
        setLayout(new GridLayout(6, 4, 5, 5));

        add(idJLabel);
        add(idTextField);
        add(atualizarJButton);
        atualizarJButton.setToolTipText("Atualizar cadastro");
        add(pesquisarJButton);
        pesquisarJButton.setToolTipText("Pesquisar");
        pesquisarJButton.setEnabled(false);
        
        
        add(nomeJLabel);
        add(nomeTextField);
        add(new JLabel());
        add(limparCamposJButton);
        limparCamposJButton.setToolTipText("Limpar campos");
     

        add(emailJLabel);
        add(emailTextField);
        add(new JLabel());
        add(adicionarNovoCadastroJButton);
        adicionarNovoCadastroJButton.setToolTipText("Novo cadastro");
        adicionarNovoCadastroJButton.setEnabled(false);
       

        add(senhaJLabel);
        add(senhaTextField);
        add(new JLabel());
        add(deletarRegistroJButton);
        deletarRegistroJButton.setToolTipText("Deletar cadastro");

        idTextField.setEnabled(false);
        atualizarJButton.setEnabled(false);

        add(primeiroRegistroJButton);
        primeiroRegistroJButton.setToolTipText("Primeiro registro");
        add(registroAnteriorJButton);
        registroAnteriorJButton.setToolTipText("Registro anterior");
        add(proximoRegistroJButton);
        proximoRegistroJButton.setToolTipText("Próximo registro");
        add(ultimoRegistroJButton);
        ultimoRegistroJButton.setToolTipText("Último registro");
        add(notificacaoJLabel);

        nomeTextField.setNextFocusableComponent(emailTextField);
        emailTextField.setNextFocusableComponent(senhaTextField);


        setSize(600, 250);
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
        limparCamposJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                limparCampos();
            }
        });
        
        adicionarNovoCadastroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                adicionarNovoCadastro();
            }
        });

        KeyAdapter keyAdapter = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                atualizarJButton.setEnabled(true);
            }
        };

        nomeTextField.addKeyListener(keyAdapter);
        emailTextField.addKeyListener(keyAdapter);
        senhaTextField.addKeyListener(keyAdapter);
        
        atualizarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                atualizarRegistro();
            }
        });
        pesquisarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                pesquisarRegistro();
            }
        });
    }

    private void carregarPrimeiroRegistro() {
        String[] resultado;
        try {
            resultado = NavegadorDeRegistro.primeiroRegistro("db_teste", "tbl_teste");
            notificacaoJLabel.setText("Primeiro registro");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarJButton.setEnabled(false);
            atualizarBotoes(resultado[0]);
        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao carregar o primeiro registro: " + e.getMessage());
        }
    }

    private void carregarUltimoRegistro() {
        String[] resultado;
        try {
            resultado = NavegadorDeRegistro.ultimoRegistro("db_teste", "tbl_teste");
            notificacaoJLabel.setText("Último registro");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarJButton.setEnabled(false);
            atualizarBotoes(resultado[0]);
        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao carregar o último registro: " + e.getMessage());
        }
    }

    private void carregarRegistroAnterior() {
        String[] resultado;
        try {
            resultado = NavegadorDeRegistro.registroAnterior("db_teste", "tbl_teste", idTextField.getText());
            notificacaoJLabel.setText("Registro anterior");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarJButton.setEnabled(false);
            atualizarBotoes(resultado[0]);
        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao carregar o registro anterior: " + e.getMessage());
        }
    }

    private void carregarProximoRegistro() {
        String[] resultado;
        try {
            resultado = NavegadorDeRegistro.proximoRegistro("db_teste", "tbl_teste", idTextField.getText());
            notificacaoJLabel.setText("Próximo registro");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarJButton.setEnabled(false);
            atualizarBotoes(resultado[0]);
        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao carregar o próximo registro: " + e.getMessage());
        }
    }

    private void deletarRegistro() {
        try {
            NavegadorDeRegistro.deletarRegistro("db_teste", "tbl_teste", idTextField.getText());
            notificacaoJLabel.setText("Registro deletado com sucesso");
            carregarPrimeiroRegistro();
        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao deletar o registro: " + e.getMessage());
        }
    }

    private void atualizarRegistro() {
        try {
            NavegadorDeRegistro.atualizarRegistro("db_teste", "tbl_teste", idTextField.getText(), nomeTextField.getText(), emailTextField.getText(), new String(senhaTextField.getPassword()));
            notificacaoJLabel.setText("Registro atualizado com sucesso");
            atualizarJButton.setEnabled(false);
        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao atualizar o registro: " + e.getMessage());
        }
    }

    private void adicionarNovoCadastro() {
        try {
            NavegadorDeRegistro.adicionarNovoRegistro("db_teste", "tbl_teste", nomeTextField.getText(), emailTextField.getText(), new String(senhaTextField.getPassword()));
            notificacaoJLabel.setText("Cadastro adicionado com sucesso");
            carregarPrimeiroRegistro();
            limparCamposJButton.setEnabled(true);
            deletarRegistroJButton.setEnabled(true);
            adicionarNovoCadastroJButton.setEnabled(false);
            pesquisarJButton.setEnabled(false);

        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao adicionar novo cadastro: " + e.getMessage());
        }
    }
    private void limparCampos() {
        nomeTextField.setText("");
        emailTextField.setText("");
        senhaTextField.setText("");
        idTextField.setText("");
        atualizarJButton.setEnabled(false);
        deletarRegistroJButton.setEnabled(false);
        limparCamposJButton.setEnabled(false);
        ultimoRegistroJButton.setEnabled(false);
        proximoRegistroJButton.setEnabled(false);
        adicionarNovoCadastroJButton.setEnabled(true);
        pesquisarJButton.setEnabled(true);
    }

    private void atualizarBotoes(String idAtual) {
        try {
            boolean primeiroRegistro = NavegadorDeRegistro.PrimeiroRegistro("db_teste", "tbl_teste", idAtual);
            boolean ultimoRegistro = NavegadorDeRegistro.UltimoRegistro("db_teste", "tbl_teste", idAtual);

            primeiroRegistroJButton.setEnabled(!primeiroRegistro);
            registroAnteriorJButton.setEnabled(!primeiroRegistro);
            proximoRegistroJButton.setEnabled(!ultimoRegistro);
            ultimoRegistroJButton.setEnabled(!ultimoRegistro);
        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao atualizar os botões: " + e.getMessage());
        }
    }
    private void pesquisarRegistro() {
        String nomeOuEmail = nomeTextField.getText().isEmpty() ? emailTextField.getText() : nomeTextField.getText();
        try {
            String[] resultado = NavegadorDeRegistro.buscarRegistro("db_teste", "tbl_teste", nomeOuEmail);
            notificacaoJLabel.setText("Registro encontrado");
            idTextField.setText(resultado[0]);
            nomeTextField.setText(resultado[1]);
            emailTextField.setText(resultado[2]);
            senhaTextField.setText(resultado[3]);
            atualizarJButton.setEnabled(false);
            atualizarBotoes(resultado[0]);
            limparCamposJButton.setEnabled(true);
            deletarRegistroJButton.setEnabled(true);
            adicionarNovoCadastroJButton.setEnabled(false);

        } catch (Exception e) {
            notificacaoJLabel.setText("Erro ao buscar o registro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new EditarCadastro();
    }
}