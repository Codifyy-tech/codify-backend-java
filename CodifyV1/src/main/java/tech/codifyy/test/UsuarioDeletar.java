package tech.codifyy.test;

import tech.codifyy.beans.Usuario;
import tech.codifyy.conexao.Conexao;
import tech.codifyy.dao.UsuarioDAO;

import java.sql.Connection;
import java.text.SimpleDateFormat;

public class UsuarioDeletar {

    public static void main(String[] args) {
        Connection con = Conexao.abrirConexao();

        Usuario user = new Usuario();

        UsuarioDAO useradao = new UsuarioDAO(con);

        // Deletar Usuario

        System.out.println(useradao.deletar(user));

        Conexao.fecharConexao(con);
    }
}
