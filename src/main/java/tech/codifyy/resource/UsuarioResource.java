package tech.codifyy.resource;


import tech.codifyy.beans.RespostaRequisição;
import tech.codifyy.beans.Usuario;
import tech.codifyy.bo.Excecao;
import tech.codifyy.bo.UsuarioBO;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/user")
public class UsuarioResource {

    private UsuarioBO usuariobo = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> buscar(){
        return usuariobo.listar();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Usuario usuario, @Context UriInfo uriInfo) {
        RespostaRequisição resposta = new RespostaRequisição();
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
