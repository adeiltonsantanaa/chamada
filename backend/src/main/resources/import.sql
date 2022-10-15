INSERT INTO tb_usuario (id, email, password, perfil) values (1,'adeilton@gmail.com', '$2a$10$4s.IyM8ItjnTfPZnPreigeQsy3vizCjtrQLRq.X4.8aTby2KJUDHK', 'ROLE_ADMINISTRADOR');
INSERT INTO tb_usuario (id, email, password, perfil) values (2,'maria@gmail.com', '$2a$10$4s.IyM8ItjnTfPZnPreigeQsy3vizCjtrQLRq.X4.8aTby2KJUDHK', 'ROLE_OPERADOR');
INSERT INTO tb_usuario (id, email, password, perfil) values (3,'joao@gmail.com', '$2a$10$4s.IyM8ItjnTfPZnPreigeQsy3vizCjtrQLRq.X4.8aTby2KJUDHK', 'ROLE_CONSULTA');





INSERT INTO tb_professor(nome) VALUES ('Lucas Mauricio');
INSERT INTO tb_aluno (id, matricula, nome) values (1,'202108672157', 'Adeilton Santana');
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO java', 'ara1001', 1);
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO 2', 'ara1001', 1);
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO 3', 'ara1001', 1);
INSERT INTO tb_disciplina_aluno (desc_id, aluno_id) values (1,1);