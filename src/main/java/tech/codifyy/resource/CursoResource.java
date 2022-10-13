package tech.codifyy.resource;

import tech.codifyy.beans.Trilha;
import tech.codifyy.conexao.Conexao;
import tech.codifyy.dao.TrilhaDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.List;

@Path("/course")
public class CursoResource {

    Connection con = Conexao.abrirConexao();

    private TrilhaDAO trilhadao = new TrilhaDAO(con);

    //Retornar todos os usuario
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trilha> buscar(){
        return trilhadao.selecionarTrilhas();
    }

    // POST REGISTER
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Trilha trilha) {
        String resposta = "{\"message\": \"Usuário cadastrado com sucesso\"}";
        trilhadao.inserir(trilha);
        Response response = Response
                .status(Response.Status.CREATED)
                .type(MediaType.APPLICATION_JSON)
                .entity(resposta)
                .build();
        return response;
    }

    //Retornar trilhas por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trilha buscar(@PathParam("id") int id){
        return trilhadao.selectId(id);
    }
}
