package com.unifio.integrador.services;

import org.junit.jupiter.api.Test;
import com.unifio.integrador.entidades.Chamado;
import com.unifio.integrador.entidades.StatusChamado;
import com.unifio.integrador.entidades.Usuario;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ChamadoServiceTest {

    @Inject
    ChamadoService chamadoService;

    @Inject
    UsuarioService usuarioService; // Precisamos dele para criar o requisitante

    @Test
    @Transactional
    void testSalvarChamado() {
        // Arrange 1: Criar e salvar a dependência (o requisitante)
        Usuario requisitante = new Usuario();
        requisitante.setNome("Ana Souza");
        requisitante.setEmail("ana.souza@teste.com");
        requisitante.setRole("REQUISITANTE");
        usuarioService.salvar(requisitante);

        // Arrange 2: Preparar o chamado
        Chamado novoChamado = new Chamado();
        novoChamado.setProtocolo("202509-001");
        novoChamado.setTitulo("Problema no computador");
        novoChamado.setDescricao("Meu computador não liga.");
        novoChamado.setStatus(StatusChamado.ABERTO);
        novoChamado.setRequisitante(requisitante); // Associa o requisitante salvo

        // Act: Salvar o chamado
        Chamado chamadoSalvo = chamadoService.salvar(novoChamado);

        // Assert: Verificar os resultados
        assertNotNull(chamadoSalvo.getId(), "O ID do chamado não deveria ser nulo.");
        assertNotNull(chamadoSalvo.getRequisitante(), "O requisitante do chamado não deveria ser nulo.");
        assertEquals("Problema no computador", chamadoSalvo.getTitulo());
        assertEquals(requisitante.getId(), chamadoSalvo.getRequisitante().getId(),
                "O ID do requisitante deve ser o mesmo.");
    }
}
