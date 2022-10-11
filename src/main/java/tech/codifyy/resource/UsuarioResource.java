package tech.codifyy.resource;


import org.json.JSONObject;
import tech.codifyy.beans.Resposta;
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

    // PUT
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Usuario usuario, @Context UriInfo uriInfo) {
        Resposta resposta = new Resposta();
        try {
            usuariobo.inserirBO(usuario);
            resposta.setMensagem("Usuário cadastrado com sucesso");
            resposta.setId(usuario.get_id());
        } catch (Excecao e) {
            throw new RuntimeException(e);
        }
        return Response.status(Response.Status.OK).entity(resposta).build();
    }
}
