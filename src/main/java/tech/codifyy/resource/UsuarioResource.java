package tech.codifyy.resource;


import tech.codifyy.services.Autenticacao;
import tech.codifyy.beans.Usuario;
import tech.codifyy.bo.UsuarioBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UsuarioResource {

    private UsuarioBO usuariobo = new UsuarioBO();


    //Retornar todos os usuario
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> buscar(){
        return usuariobo.listar();
    }

    //Retornar usuario por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario buscar(@PathParam("id") int id){
        return usuariobo.listar(id);
    }

    // POST REGISTER
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Usuario usuario) {
        String resposta = "{\"message\": \"Usuário cadastrado com sucesso\"}";
        usuariobo.inserirBO(usuario);
        Response response = Response
                .status(Response.Status.CREATED)
                .type(MediaType.APPLICATION_JSON)
                .entity(resposta)
                .build();
        return response;
    }

    // POST LOGIN
    @POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response autenticar(Autenticacao aut) {
            Usuario usuario = usuariobo.listarEmail(aut);
            String respostaErro = "{\"message\": \"Error ao cadastrar\"}";
            String respostaCerta = "{\"token\": " + usuario.get_id() + "}";
        Response response;
        if (usuario.getEmail().equals(aut.getEmail()) && usuario.getPassword().equals(aut.getPassword())) {
            response = Response
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(respostaCerta)
                    .build();
        } else{
            response = Response
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(respostaErro)
                    .build();
        }
        return response;
    }

    //PUT
}
