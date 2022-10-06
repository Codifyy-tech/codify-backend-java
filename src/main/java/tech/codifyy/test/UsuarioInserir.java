package tech.codifyy.test;

import tech.codifyy.beans.Usuario;
import tech.codifyy.bo.Excecao;
import tech.codifyy.bo.UsuarioBO;
import tech.codifyy.conexao.Conexao;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UsuarioInserir {

    public static void main(String[] args) throws Excecao, ParseException {

        Connection con = Conexao.abrirConexao();

        Usuario user = new Usuario();

        UsuarioBO userbo = new UsuarioBO();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Inserir usuario
        
        user.setEmail("codifyDOIS@teste.com");
        user.setGenero("H");
        user.setNome("Rafael Mafort");
        user.setSenha("senha123");
        user.setTelefone(11988887777L);
        user.setNascimento(sdf.parse("22/09/2003"));
        user.setTipo("Admin");
        user.setEndereco("Avenida Paulista 1100");
        user.setCep(12345678);
        user.setCidade("São Paulo");
        user.setDistrito("Pinheiros");
        user.setEstado("SP");

        userbo.inserirBO(user);

        Conexao.fecharConexao(con);
    }
}
