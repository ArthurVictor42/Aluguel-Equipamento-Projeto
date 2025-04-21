package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static String url = "jdbc:mysql://localhost:3306/projetoaluguel";
    private static String usuario = "root";
    private static String senha = "";

    public static Connection conexao() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }
}