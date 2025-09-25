package com.unifio.integrador.services;

import java.util.List;

import com.unifio.integrador.entidades.Usuario;
import com.unifio.integrador.repositories.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.listAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        usuarioRepository.persist(usuario);
        return usuario;
    }

    @Transactional
    public Usuario atualizar(Long id, Usuario dados) {
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario == null) return null;
        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        usuario.setRole(dados.getRole());
        return usuario;
    }

    @Transactional
    public boolean deletar(Long id) {
        return usuarioRepository.deleteById(id);
    }
}