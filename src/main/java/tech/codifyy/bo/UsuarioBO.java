package tech.codifyy.bo;

import tech.codifyy.beans.Usuario;
import tech.codifyy.conexao.Conexao;
import tech.codifyy.dao.UsuarioDAO;

import java.sql.Connection;
import java.util.List;


public class UsuarioBO {

    Connection con = Conexao.abrirConexao();

    UsuarioDAO usuariodao = new UsuarioDAO(con);

    // Inserir usuario REGRAS
    public void inserirBO(Usuario user) throws Excecao {
        if (!user.getEmail().contains("@")) {
            System.out.println("Email invalido");
        }
        if(user.getGenre().length() > 2){
            System.out.println("Genero invalido");
        }
        if(!user.getName().contains(" ")){
            System.out.println("Digite seu nome completo.");
        }
        if(user.getPassword().length()< 6){
            System.out.println("A senha deve ter pelo menos 6 caracteres");
        }
        if(user.getBirth_date() == null){
            System.out.println("Campo obrigatório");
        }
        if(user.getAddress() == null){
            System.out.println("Campo obrigatório");
        }
        if(user.getCep() == null){
            System.out.println("CEP Inválido");
        }
        if(user.getCity() == null){
            System.out.println("Campo obrigatório");
        }
        if(user.getDistrict() == null){
            System.out.println("Campo obrigatório");
        }
        if(user.getState() == null){
            System.out.println("Campo obrigatório");
        }
        else{
            user.setEmail(user.getEmail());
            user.setGenre(user.getGenre());
            user.setName(user.getName());
            user.setPassword(user.getPassword());
            user.setBirth_date(user.getBirth_date());
            user.setAddress(user.getAddress());
            user.setCep(user.getCep());
            user.setCity(user.getCity());
            user.setDistrict(user.getDistrict());
            user.setState(user.getState());
            System.out.println(usuariodao.inserir(user));
        }
    }

    // Selecionar Usuarios
    public List<Usuario> listar(){
        // Regras de negocio
        return usuariodao.select();
    }

    // Selecionar por ID
    public Usuario listar(int id){
        return usuariodao.select(id);
    }

}
