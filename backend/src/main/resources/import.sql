INSERT INTO tb_aluno(matricula, nome) VALUES (0101, 'adeilton');
INSERT INTO tb_professor(nome) VALUES ('lucas');
INSERT INTO tb_turma_disciplina(disciplina_nome, turma_nome, professor) VALUES ('poo java', 'ara101', 1);
INSERT INTO tb_disciplina_aluno(fk_turma_disc, fk_aluno) VALUES (1, 1);
INSERT INTO tb_registro_chamada(data_registro, fk_aluno, fk_turma_disc) VALUES ('2021-01-01', 1, 1);