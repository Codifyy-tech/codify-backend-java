package tech.codifyy.test;

import tech.codifyy.beans.Usuario;
import tech.codifyy.conexao.Conexao;
import tech.codifyy.dao.UsuarioDAO;

import java.sql.Connection;

public class UsuarioAlterarSenha {

    public static void main(String[] args) {
        Connection con = Conexao.abrirConexao();

        Usuario usuario = new Usuario();
        UsuarioDAO usuariodao = new UsuarioDAO(con);

        // alterar endereco por nome
        usuario.setSenha("novasenha");
        usuario.setId(7);
        System.out.println(usuariodao.alterarSenha(usuario));

        Conexao.fecharConexao(con);
    }
}
