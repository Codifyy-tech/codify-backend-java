package tech.codifyy.bo;

import tech.codifyy.beans.Usuario;
import tech.codifyy.conexao.Conexao;
import tech.codifyy.dao.UsuarioDAO;

import java.sql.Connection;
import java.util.List;


public class UsuarioBO {

    Connection con = Conexao.abrirConexao();

    UsuarioDAO usuariodao = new UsuarioDAO(con);

    // Inserir usuario
    public void inserirBO(Usuario user) throws Excecao {
        if (user.getEmail().contains("@") == false) {
            System.out.println("Email invalido");
        } else {
            user.setEmail(user.getEmail());
            System.out.println(usuariodao.inserir(user));
        }
    }

    // Selecionar Usuario

    public List<Usuario> listar(){
        return usuariodao.select();
    }

}
