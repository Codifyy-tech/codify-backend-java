package tech.codifyy.bo;

import tech.codifyy.services.Autenticacao;
import tech.codifyy.beans.Usuario;
import tech.codifyy.conexao.Conexao;
import tech.codifyy.dao.UsuarioDAO;
import tech.codifyy.exception.Excecao;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;


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
        if (!Objects.equals(user.getConfirm_password(), user.getPassword())){
            return "As senhas não correspondem";
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
            user.setPassword(user.getConfirm_password());
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

    //Selecionar por Email
    public Usuario listarEmail(Autenticacao aut) {
        String email = aut.getEmail();
        return usuariodao.selecionarEmail(email);
    }

    //Alterar Senha

}
