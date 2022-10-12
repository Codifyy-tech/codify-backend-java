package tech.codifyy.resource;


import oracle.jdbc.proxy.annotation.Post;
import org.json.JSONObject;
import tech.codifyy.beans.Autenticacao;
import tech.codifyy.beans.RespostaCadastro;
import tech.codifyy.beans.Usuario;
import tech.codifyy.bo.Excecao;
import tech.codifyy.bo.UsuarioBO;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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

    // POST
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Usuario usuario) {
//        RespostaCadastro resposta = new RespostaCadastro("Usuário cadastrado com sucesso");
        String resposta = "{\"message\": \"Usuário cadastrado com sucesso\"}";
        usuariobo.inserirBO(usuario);
        Response response = Response
                .status(Response.Status.CREATED)
                .type(MediaType.APPLICATION_JSON)
                .entity(resposta)
                .build();
        return response;
    }

    @POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response autenticar(Autenticacao aut) {
            Usuario usuario = usuariobo.listarEmail(aut);
            if (usuario.getEmail().equals(aut.getEmail()) && usuario.getPassword().equals(aut.getPassword())) {
                return Response
                        .status(Response.Status.OK)
                        .type(MediaType.APPLICATION_JSON)
                        .build();
            }
        return null;
    }
}
