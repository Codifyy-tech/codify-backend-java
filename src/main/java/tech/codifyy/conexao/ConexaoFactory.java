package tech.codifyy.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public static void main(String[] args) throws SQLException{
        Connection conexao = null;
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        conexao = DriverManager.getConnection(url, "USER", "SENHA");
        System.out.println("Abriu conexao");
        conexao.close();
    }

}
