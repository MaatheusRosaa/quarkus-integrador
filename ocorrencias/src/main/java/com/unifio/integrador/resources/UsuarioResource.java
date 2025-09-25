package com.unifio.integrador.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import com.unifio.integrador.entidades.Usuario;
import com.unifio.integrador.services.UsuarioService;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Usuario buscar(@PathParam("id") Long id) {
        return usuarioService.buscarPorId(id);
    }

    @POST
    public Response criar(Usuario usuario) {
        Usuario novo = usuarioService.salvar(usuario);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Usuario usuario) {
        Usuario atualizado = usuarioService.atualizar(id, usuario);
        if (atualizado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = usuarioService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}