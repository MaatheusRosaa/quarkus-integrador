package com.unifio.integrador.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import com.unifio.integrador.entidades.Chamado;
import com.unifio.integrador.services.ChamadoService;

@Path("/chamados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChamadoResource {

    @Inject
    ChamadoService chamadoService;

    @GET
    public List<Chamado> listar() {
        return chamadoService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Chamado buscar(@PathParam("id") Long id) {
        return chamadoService.buscarPorId(id);
    }

    @POST
    public Response criar(Chamado chamado) {
        Chamado novo = chamadoService.salvar(chamado);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Chamado chamado) {
        Chamado atualizado = chamadoService.atualizar(id, chamado);
        if (atualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = chamadoService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}