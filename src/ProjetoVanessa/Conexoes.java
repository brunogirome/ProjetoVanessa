package ProjetoVanessa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class Conexoes {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/projetovanessa";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    protected static Connection con = abrirConexao();

    protected static PreparedStatement stmt = null;

    protected static ResultSet rs = null;

    public static Connection abrirConexao() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro na criação da conexão com o banco de dados:\n" + e);
            System.out.println(e);
            throw new RuntimeException();
        }
    }

    public static void fecharConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão:\n" + e);
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt) {
        fecharConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar Statement:\n" + e);
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        fecharConexao(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar ResultSet:\n" + e);
        }
    }

}
