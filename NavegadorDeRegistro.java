import java.sql.*;

public class NavegadorDeRegistro {
    public static String[] primeiroRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlPrimeiroRegistro = "SELECT * FROM " + db + "." + tbl + " ORDER BY id ASC LIMIT 1;";
        Statement stmSqlPrimeiroRegistro = conexao.createStatement();
        ResultSet rstSqlPrimeiroRegistro = stmSqlPrimeiroRegistro.executeQuery(strSqlPrimeiroRegistro);
        rstSqlPrimeiroRegistro.next();
        String[] resultado = {
            rstSqlPrimeiroRegistro.getString("id"),
            rstSqlPrimeiroRegistro.getString("nome"),
            rstSqlPrimeiroRegistro.getString("email"),
            rstSqlPrimeiroRegistro.getString("senha")
        };
        stmSqlPrimeiroRegistro.close();
        return resultado;
    }

    public static String[] ultimoRegistro(String db, String tbl) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlUltimoRegistro = "SELECT * FROM " + db + "." + tbl + " ORDER BY id DESC LIMIT 1;";
        Statement stmSqlUltimoRegistro = conexao.createStatement();
        ResultSet rstSqlUltimoRegistro = stmSqlUltimoRegistro.executeQuery(strSqlUltimoRegistro);
        rstSqlUltimoRegistro.next();
        String[] resultado = {
            rstSqlUltimoRegistro.getString("id"),
            rstSqlUltimoRegistro.getString("nome"),
            rstSqlUltimoRegistro.getString("email"),
            rstSqlUltimoRegistro.getString("senha")
        };
        stmSqlUltimoRegistro.close();
        return resultado;
    }

    public static String[] registroAnterior(String db, String tbl, String currentId) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlRegistroAnterior = "SELECT * FROM " + db + "." + tbl + " WHERE id < " + currentId + " ORDER BY id DESC LIMIT 1;";
        Statement stmSqlRegistroAnterior = conexao.createStatement();
        ResultSet rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery(strSqlRegistroAnterior);
        rstSqlRegistroAnterior.next();
        String[] resultado = {
            rstSqlRegistroAnterior.getString("id"),
            rstSqlRegistroAnterior.getString("nome"),
            rstSqlRegistroAnterior.getString("email"),
            rstSqlRegistroAnterior.getString("senha")
        };
        stmSqlRegistroAnterior.close();
        return resultado;
    }

    public static String[] proximoRegistro(String db, String tbl, String currentId) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlProximoRegistro = "SELECT * FROM " + db + "." + tbl + " WHERE id > " + currentId + " ORDER BY id ASC LIMIT 1;";
        Statement stmSqlProximoRegistro = conexao.createStatement();
        ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
        rstSqlProximoRegistro.next();
        String[] resultado = {
            rstSqlProximoRegistro.getString("id"),
            rstSqlProximoRegistro.getString("nome"),
            rstSqlProximoRegistro.getString("email"),
            rstSqlProximoRegistro.getString("senha")
        };
        stmSqlProximoRegistro.close();
        return resultado;
    }

    public static boolean isPrimeiroRegistro(String db, String tbl, String currentId) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlPrimeiroRegistro = "SELECT id FROM " + db + "." + tbl + " ORDER BY id ASC LIMIT 1;";
        Statement stmSqlPrimeiroRegistro = conexao.createStatement();
        ResultSet rstSqlPrimeiroRegistro = stmSqlPrimeiroRegistro.executeQuery(strSqlPrimeiroRegistro);
        rstSqlPrimeiroRegistro.next();
        boolean isPrimeiro = rstSqlPrimeiroRegistro.getString("id").equals(currentId);
        stmSqlPrimeiroRegistro.close();
        return isPrimeiro;
    }

    public static boolean isUltimoRegistro(String db, String tbl, String currentId) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlUltimoRegistro = "SELECT id FROM " + db + "." + tbl + " ORDER BY id DESC LIMIT 1;";
        Statement stmSqlUltimoRegistro = conexao.createStatement();
        ResultSet rstSqlUltimoRegistro = stmSqlUltimoRegistro.executeQuery(strSqlUltimoRegistro);
        rstSqlUltimoRegistro.next();
        boolean isUltimo = rstSqlUltimoRegistro.getString("id").equals(currentId);
        stmSqlUltimoRegistro.close();
        return isUltimo;
    }

    public static void atualizarRegistro(String db, String tbl, String id, String nome, String email, String senha) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlAtualizar = "UPDATE " + db + "." + tbl + " SET nome = ?, email = ?, senha = ? WHERE id = ?;";
        PreparedStatement pstAtualizar = conexao.prepareStatement(strSqlAtualizar);
        pstAtualizar.setString(1, nome);
        pstAtualizar.setString(2, email);
        pstAtualizar.setString(3, senha);
        pstAtualizar.setString(4, id);
        pstAtualizar.executeUpdate();
        pstAtualizar.close();
    }

    public static void deletarRegistro(String db, String tbl, String id) throws Exception {
        Connection conexao = MySQLConnector.conectar();
        String strSqlDeletar = "DELETE FROM " + db + "." + tbl + " WHERE id = ?;";
        PreparedStatement Deletar = conexao.prepareStatement(strSqlDeletar);
        Deletar.setString(1, id);
        Deletar.executeUpdate();
        Deletar.close();
    }
}
