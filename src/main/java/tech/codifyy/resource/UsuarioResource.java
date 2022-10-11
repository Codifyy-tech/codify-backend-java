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
    public Response cadastrar(Usuario usuario, @Context UriInfo uriInfo) {
        RespostaCadastro resposta = new RespostaCadastro();
        try {
            String retorno = usuariobo.inserirBO(usuario);
            if (retorno.equals("Inserido com sucesso")) {
                resposta.setMensagem("Usuário cadastrado com sucesso");
                return Response.status(Response.Status.OK).entity(resposta).build();
            } else {
                resposta.setMensagem(retorno);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resposta).build();
            }
        } catch (Excecao e) {
            throw new RuntimeException(e);
        }
    }
}
