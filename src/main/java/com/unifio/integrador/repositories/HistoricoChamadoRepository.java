package com.unifio.integrador.repositories;

import com.unifio.integrador.entidades.HistoricoChamado;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HistoricoChamadoRepository implements PanacheRepository<HistoricoChamado> {
}
