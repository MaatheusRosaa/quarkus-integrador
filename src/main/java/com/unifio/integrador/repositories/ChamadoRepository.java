package com.unifio.integrador.repositories;

import com.unifio.integrador.entidades.Chamado;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChamadoRepository implements PanacheRepository<Chamado> {
}