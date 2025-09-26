package com.unifio.integrador.services;

import java.util.List;

import com.unifio.integrador.entidades.HistoricoChamado;
import com.unifio.integrador.repositories.HistoricoChamadoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class HistoricoChamadoService {

    @Inject
    HistoricoChamadoRepository historicoChamadoRepository;

    public List<HistoricoChamado> listarTodos() {
        return historicoChamadoRepository.listAll();
    }

    public HistoricoChamado buscarPorId(Long id) {
        return historicoChamadoRepository.findById(id);
    }

    @Transactional
    public HistoricoChamado salvar(HistoricoChamado historico) {
        historicoChamadoRepository.persist(historico);
        return historico;
    }

    @Transactional
    public boolean deletar(Long id) {
        return historicoChamadoRepository.deleteById(id);
    }
}