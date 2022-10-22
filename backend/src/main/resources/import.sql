INSERT INTO tb_usuario (id, email, password, perfil) values (1,'adeilton@gmail.com', '$2a$10$4s.IyM8ItjnTfPZnPreigeQsy3vizCjtrQLRq.X4.8aTby2KJUDHK', 'ROLE_ADMINISTRADOR');
INSERT INTO tb_usuario (id, email, password, perfil) values (2,'maria@gmail.com', '$2a$10$4s.IyM8ItjnTfPZnPreigeQsy3vizCjtrQLRq.X4.8aTby2KJUDHK', 'ROLE_OPERADOR');
INSERT INTO tb_usuario (id, email, password, perfil) values (3,'joao@gmail.com', '$2a$10$4s.IyM8ItjnTfPZnPreigeQsy3vizCjtrQLRq.X4.8aTby2KJUDHK', 'ROLE_CONSULTA');





INSERT INTO tb_professor(nome) VALUES ('Lucas Mauricio');
INSERT INTO tb_aluno (id, matricula, nome) values (999,'202108672157', 'Adeilton Santana');
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO java', 'ara1001', 1);
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO 2', 'ara1001', 1);
INSERT INTO tb_disciplina(disciplina_nome, turma_nome, professor) VALUES ('POO 3', 'ara1001', 1);
INSERT INTO tb_disciplina_aluno (desc_id, aluno_id) values (1,1);


INSERT INTO TB_REGISTRO_CHAMADA (id, data_registro, matricula, fk_turma_disc) VALUES (999, '2022-01-01', '202108672157', 1);
INSERT INTO TB_REGISTRO_CHAMADA (id, data_registro, matricula, fk_turma_disc) VALUES (998, '2022-01-02', '202108672158', 2);
INSERT INTO TB_REGISTRO_CHAMADA (id, data_registro, matricula, fk_turma_disc) VALUES (997, '2022-01-03', '202108672159', 3);
insert into tb_registro_aula (id, data_registro, descricao, fk_turma_disc, professor) values (999, '2022-01-01', 'teste', 1, 1)