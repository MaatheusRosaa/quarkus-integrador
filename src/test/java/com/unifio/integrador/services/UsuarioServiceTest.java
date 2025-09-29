package com.unifio.integrador.services;

import org.junit.jupiter.api.Test;
import com.unifio.integrador.entidades.Usuario;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class UsuarioServiceTest {

    @Inject
    UsuarioService usuarioService;

    @Test
    @Transactional
    void testSalvarUsuario() {
        // Arrange: Prepara o objeto a ser salvo
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome("João da Silva");
        novoUsuario.setEmail("joao.silva@teste.com");
        novoUsuario.setRole("REQUISITANTE");

        // Act: Executa a ação de salvar
        Usuario usuarioSalvo = usuarioService.salvar(novoUsuario);

        // Assert: Verifica se o resultado é o esperado
        assertNotNull(usuarioSalvo.getId(), "O ID do usuário não deveria ser nulo após salvar.");
        assertEquals("João da Silva", usuarioSalvo.getNome());
        assertEquals("joao.silva@teste.com", usuarioSalvo.getEmail());
    }
}