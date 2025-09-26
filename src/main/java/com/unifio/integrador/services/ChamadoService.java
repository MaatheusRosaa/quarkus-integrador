package com.unifio.integrador.services;

import java.util.List;

import com.unifio.integrador.entidades.Chamado;
import com.unifio.integrador.repositories.ChamadoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ChamadoService {

    @Inject
    ChamadoRepository chamadoRepository;

    public List<Chamado> listarTodos() {
        return chamadoRepository.listAll();
    }

    public Chamado buscarPorId(Long id) {
        return chamadoRepository.findById(id);
    }

    @Transactional
    public Chamado salvar(Chamado chamado) {
        chamadoRepository.persist(chamado);
        return chamado;
    }

    @Transactional
    public Chamado atualizar(Long id, Chamado dados) {
        Chamado chamado = chamadoRepository.findById(id);
        if (chamado == null) return null;
        chamado.setTitulo(dados.getTitulo());
        chamado.setDescricao(dados.getDescricao());
        chamado.setStatus(dados.getStatus());
        return chamado;
    }

    @Transactional
    public boolean deletar(Long id) {
        return chamadoRepository.deleteById(id);
    }
}