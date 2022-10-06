package tech.codifyy.resource;

import tech.codifyy.beans.Usuario;
import tech.codifyy.bo.UsuarioBO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuariobo = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> buscar(){
        return usuariobo.listar();
    }
}
