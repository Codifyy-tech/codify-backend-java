package tech.codifyy.resource;


import org.json.JSONObject;
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

@Path("/usuario")
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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Usuario usuario) {
        RespostaCadastro resposta = new RespostaCadastro("Usuário cadastrado com sucesso");
        usuariobo.inserirBO(usuario);
        Response response = Response
                .status(Response.Status.CREATED)
                .type(MediaType.APPLICATION_JSON)
                .entity(resposta)
                .build();
        return response;
    }
}
