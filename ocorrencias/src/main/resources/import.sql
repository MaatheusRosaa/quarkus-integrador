-- ===== USUARIOS =====
INSERT INTO usuario (id, nome, email, role) VALUES (1, 'Gabriel', 'gabriel@email.com', 'CIDADÃO');
INSERT INTO usuario (id, nome, email, role) VALUES (2, 'Maria', 'maria@email.com', 'CIDADÃO');
INSERT INTO usuario (id, nome, email, role) VALUES (3, 'João', 'joao@email.com', 'CIDADÃO');
INSERT INTO usuario (id, nome, email, role) VALUES (4, 'Ana', 'ana@email.com', 'AGENTE');
INSERT INTO usuario (id, nome, email, role) VALUES (5, 'Carlos', 'carlos@email.com', 'AGENTE');

-- ===== CHAMADOS =====
INSERT INTO chamado (id, protocolo, titulo, descricao, status, requisitante_id) VALUES (1, 'CHAM-001', 'Buraco na rua', 'Existe um buraco enorme na rua X', 'ABERTO', 1);
INSERT INTO chamado (id, protocolo, titulo, descricao, status, requisitante_id) VALUES (2, 'CHAM-002', 'Luz queimada', 'A lâmpada do poste Y está queimada', 'ABERTO', 2);
INSERT INTO chamado (id, protocolo, titulo, descricao, status, requisitante_id) VALUES (3, 'CHAM-003', 'Água vazando', 'Vazamento no hidrante da praça Z', 'ABERTO', 3);
INSERT INTO chamado (id, protocolo, titulo, descricao, status, requisitante_id) VALUES (4, 'CHAM-004', 'Sinalização ausente', 'Falta placa de trânsito na avenida W', 'ABERTO', 1);
INSERT INTO chamado (id, protocolo, titulo, descricao, status, requisitante_id) VALUES (5, 'CHAM-005', 'Calçada quebrada', 'Calçada da rua V precisa de reparo', 'ABERTO', 2);

-- ===== HISTORICO_CHAMADO =====
INSERT INTO historico_chamado (id, descricao, data_hora, chamado_id, responsavel_id) VALUES (1, 'Chamado criado', '2025-09-25 10:00:00', 1, 4);
INSERT INTO historico_chamado (id, descricao, data_hora, chamado_id, responsavel_id) VALUES (2, 'Chamado analisado', '2025-09-25 11:00:00', 2, 5);
INSERT INTO historico_chamado (id, descricao, data_hora, chamado_id, responsavel_id) VALUES (3, 'Status alterado para em andamento', '2025-09-25 12:00:00', 3, 4);
INSERT INTO historico_chamado (id, descricao, data_hora, chamado_id, responsavel_id) VALUES (4, 'Responsável designado', '2025-09-25 13:00:00', 4, 5);
INSERT INTO historico_chamado (id, descricao, data_hora, chamado_id, responsavel_id) VALUES (5, 'Chamado resolvido', '2025-09-25 14:00:00', 5, 4);
