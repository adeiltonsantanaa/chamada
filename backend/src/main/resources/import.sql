INSERT INTO tb_professor(nome) VALUES ('lucas');
INSERT INTO tb_aluno(matricula, nome) values (2021, 'adeilton');
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO java', 'ara1001', 1);
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO 2', 'ara1001', 1);
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO 3', 'ara1001', 1);
INSERT INTO tb_disciplina_aluno (desc_id, aluno_id) values (1,1);
INSERT INTO tb_user(id, username, password) values (1,'adeilton', '$2a$10$4s.IyM8ItjnTfPZnPreigeQsy3vizCjtrQLRq.X4.8aTby2KJUDHK');
INSERT INTO tb_user_role VALUES (1, 'ROLE_ADMIN')
