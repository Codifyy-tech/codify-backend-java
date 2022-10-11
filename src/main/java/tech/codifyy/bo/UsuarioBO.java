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
    public String inserirBO(Usuario user) throws Excecao {
        if (!user.getEmail().contains("@")) {
            return "Email invalido";
        }
        if(user.getGenre().length() > 2){
            return "Genero invalido";
        }
        if(!user.getName().contains(" ")){
            return "Digite seu nome completo.";
        }
        if(user.getPassword().length()< 6){
            return "A senha deve ter pelo menos 6 caracteres";
        }
        if(user.getBirth_date() == null){
            return "Campo obrigatório";
        }
        if(user.getAddress() == null){
            return "Campo obrigatório";
        }
        if(user.getCep() == null){
            return "CEP Inválido";
        }
        if(user.getCity() == null){
            return "Campo obrigatório";
        }
        if(user.getDistrict() == null){
            return "Campo obrigatório";
        }
        if(user.getState() == null){
            return "Campo obrigatório";
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
            return usuariodao.inserir(user);
        }
    }

    // Selecionar Usuarios
    public List<Usuario> listar(){
        // Regras de negocio
        return usuariodao.select();
    }

    // Selecionar por ID
    public Usuario listar(int id){
        return usuariodao.selectId(id);
    }

}
