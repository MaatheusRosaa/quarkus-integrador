package com.unifio.integrador.resources;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import com.unifio.integrador.entidades.HistoricoChamado;
import com.unifio.integrador.services.HistoricoChamadoService;

@Path("/historicos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoricoChamadoResource {

    @Inject
    HistoricoChamadoService historicoChamadoService;

    @GET
    public List<HistoricoChamado> listar() {
        return historicoChamadoService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public HistoricoChamado buscar(@PathParam("id") Long id) {
        return historicoChamadoService.buscarPorId(id);
    }

    @POST
    public Response criar(HistoricoChamado historico) {
        HistoricoChamado novo = historicoChamadoService.salvar(historico);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = historicoChamadoService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}