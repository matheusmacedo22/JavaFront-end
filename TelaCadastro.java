import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaCadastro extends JFrame {

    private final JTextField nomeTextField = new JTextField();
    private final JTextField emailTextField = new JTextField();
    private final JPasswordField senhaTextField = new JPasswordField();
    private final JLabel nomeJLabel = new JLabel("Nome:");
    private final JLabel emailJLabel = new JLabel("E-mail:");
    private final JLabel senhaJLabel = new JLabel("Senha:");
    
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JButton voltarJButton = new JButton("Voltar");
    private final JLabel notificacoesJLabel = new JLabel("Notificações...");
    private final JCheckBox termosCheckBox = new JCheckBox("Aceito os termos");

    public TelaCadastro() {
        super("Cadastro");
        setLayout(new GridLayout(11, 1, 5, 5));

        JPanel linha1 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha2 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha3 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha4 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha5 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha6 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha7 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha8 = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha9 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha10 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha11 = new JPanel(new GridLayout(1, 1, 5, 5));

        add(linha1);

        linha2.add(nomeJLabel);
        add(linha2);

        linha3.add(nomeTextField);
        add(linha3);

        linha4.add(emailJLabel);
        add(linha4);

        linha5.add(emailTextField);
        add(linha5);

        linha6.add(senhaJLabel);
        add(linha6);

        linha7.add(senhaTextField);
        add(linha7);

        linha8.add(cadastrarJButton);
        linha8.add(voltarJButton);
        add(linha8);

        linha9.add(termosCheckBox);
        add(linha9);

        linha10.add(notificacoesJLabel);
        add(linha10);

        add(linha11);

        cadastrarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!termosCheckBox.isSelected()) {
                    notificacoesJLabel.setText("Você deve aceitar os termos para se cadastrar.");
                    return;
                }

                String nome = nomeTextField.getText();
                String email = emailTextField.getText();
                String senha = new String(senhaTextField.getPassword());
                
                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    notificacoesJLabel.setText("Por favor, preencha todos os campos.");
                } else {
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String sql = "INSERT INTO tbl_usuarios (nome, email, senha) VALUES (?, ?, ?)";
                        PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1, nome);
                        stmt.setString(2, email);
                        stmt.setString(3, senha);
                        stmt.executeUpdate();
                        
                        stmt.close();
                        conexao.close();
                        
                        notificacoesJLabel.setText("Cadastro realizado com sucesso.");
                        
                        dispose();
                        new TelaLogin();
                        
                    } catch (SQLException ex) {
                        notificacoesJLabel.setText("Erro ao realizar cadastro: " + ex.getMessage());
                    }
                }
            }
        });

        voltarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new TelaLogin(); 
            }
        });

        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaCadastro();
    }
}
