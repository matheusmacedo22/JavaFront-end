import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaLogin extends JFrame {

    private final JTextField loginTextField = new JTextField();
    private final JPasswordField senhaTextField = new JPasswordField();
    private final JLabel loginJLabel = new JLabel("Usuário:");
    private final JLabel senhaJLabel = new JLabel("Senha:");
    
    private final JButton entrarJButton = new JButton("Entrar");
    private final JButton adicionarCadastroJButton = new JButton("Novo");
    private final JLabel notificacoesJLabel = new JLabel("Notificações...");

    public TelaLogin() {
        super("Login");
        setLayout(new GridLayout(8, 1, 5, 5));

        JPanel linha1 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha2 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha3 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha4 = new JPanel(new GridLayout(1, 3, 5, 5));
        JPanel linha5 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha6 = new JPanel(new GridLayout(1, 1, 5, 5));
        JPanel linha7 = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha8 = new JPanel(new GridLayout(1, 1, 5, 5));

        add(linha1);
        linha2.add(loginJLabel);
        add(linha2);

        linha3.add(loginTextField);
        add(linha3);

        linha4.add(senhaJLabel);
        add(linha4);

        linha5.add(senhaTextField);
        add(linha5);

        linha6.add(entrarJButton);
        linha6.add(adicionarCadastroJButton);
        add(linha6);

        add(linha7);

        linha8.add(notificacoesJLabel);
        add(linha8);

        entrarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = loginTextField.getText();
                String senha = new String(senhaTextField.getPassword());
                
                if (login.isEmpty() || senha.isEmpty()) {
                    notificacoesJLabel.setText("Por favor, preencha todos os campos.");
                } else {
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String sql = "SELECT * FROM tbl_usuarios WHERE email = ? AND senha = ?";
                        PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1, login);
                        stmt.setString(2, senha);
                        ResultSet rs = stmt.executeQuery();
                        
                        if (rs.next()) {
                            notificacoesJLabel.setText("Login realizado com sucesso.");
                            dispose(); 
                            new EditarCadastro(); 
                        } else {
                            notificacoesJLabel.setText("Login ou senha incorretos.");
                        }
                        
                        rs.close();
                        stmt.close();
                        conexao.close();
                    } catch (SQLException ex) {
                        notificacoesJLabel.setText("Erro ao realizar login: " + ex.getMessage());
                    }
                }
            }
        });

        adicionarCadastroJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new TelaCadastro(); 
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaLogin();
    }
}
