package com.unifio.integrador.services;

import org.junit.jupiter.api.Test;
import com.unifio.integrador.entidades.Chamado;
import com.unifio.integrador.entidades.HistoricoChamado;
import com.unifio.integrador.entidades.StatusChamado;
import com.unifio.integrador.entidades.Usuario;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class HistoricoChamadoServiceTest {

    @Inject
    HistoricoChamadoService historicoChamadoService;

    @Inject
    ChamadoService chamadoService;

    @Inject
    UsuarioService usuarioService;

    @Test
    @Transactional
    void testSalvarHistoricoChamado() {
        //Criar o requisitante do chamado
        Usuario requisitante = new Usuario();
        requisitante.setNome("Carlos Pereira");
        requisitante.setEmail("carlos.pereira@teste.com");
        requisitante.setRole("REQUISITANTE");
        usuarioService.salvar(requisitante);

        //Criar o responsável pelo histórico
        Usuario responsavel = new Usuario();
        responsavel.setNome("Maria Oliveira");
        responsavel.setEmail("maria.oliveira@teste.com");
        responsavel.setRole("SUPORTE");
        usuarioService.salvar(responsavel);

        //Criar o chamado
        Chamado chamado = new Chamado();
        chamado.setTitulo("Impressora offline");
        chamado.setDescricao("A impressora do setor fiscal não está funcionando.");
        chamado.setStatus(StatusChamado.ABERTO);
        chamado.setRequisitante(requisitante);
        chamadoService.salvar(chamado);

        // Preparar o histórico do chamado
        HistoricoChamado novoHistorico = new HistoricoChamado();
        novoHistorico.setDescricao("Primeira análise realizada. Verificando conexão de rede.");
        novoHistorico.setDataHora(LocalDateTime.now());
        novoHistorico.setChamado(chamado); // Associa o chamado
        novoHistorico.setResponsavel(responsavel); // Associa o responsável

        //Salvar o histórico
        HistoricoChamado historicoSalvo = historicoChamadoService.salvar(novoHistorico);

        //Verificar os resultados
        assertNotNull(historicoSalvo.getId(), "O ID do histórico não deveria ser nulo.");
        assertNotNull(historicoSalvo.getChamado(), "O chamado associado não deveria ser nulo.");
        assertNotNull(historicoSalvo.getResponsavel(), "O responsável associado não deveria ser nulo.");
        assertEquals(chamado.getId(), historicoSalvo.getChamado().getId());
        assertEquals(responsavel.getId(), historicoSalvo.getResponsavel().getId());
        assertEquals("Primeira análise realizada. Verificando conexão de rede.", historicoSalvo.getDescricao());
    }
}