package tech.codifyy.test;

import tech.codifyy.beans.Usuario;
import tech.codifyy.exception.Excecao;
import tech.codifyy.bo.UsuarioBO;
import tech.codifyy.conexao.Conexao;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UsuarioCadastrar {

    public static void main(String[] args) throws Excecao, ParseException {

        Connection con = Conexao.abrirConexao();

        Usuario user = new Usuario();

        UsuarioBO userbo = new UsuarioBO();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Inserir usuario
        
        user.setEmail("codifyy@teste.com");
        user.setGenre("H");
        user.setName("Rafael Mafort");
        user.setPassword("senha123");
        user.setConfirm_password("senha123");
        user.setPhone(11988887777L);
        user.setBirth_date(sdf.parse("22/09/2003"));
        user.setType("Admin");
        user.setAddress("Avenida Paulista 1100");
        user.setCep(12345678);
        user.setCity("São Paulo");
        user.setDistrict("Pinheiros");
        user.setState("SP");

        System.out.println(userbo.inserirBO(user));

        Conexao.fecharConexao(con);
    }
}
