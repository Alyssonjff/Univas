==================================================
- SISTEMAS DE INFORMAÇÃO P4                      -
- CONSULTA E MANIPULAÇÃO DE DADOS - PRÁTICA 3    -
- PROF. LUIZ GUSTAVO DIAS luizdias@univas.edu.br -
==================================================


-- ATIVIDADE PRÁTICA PARA APLICAR O CONHECIMENTO SOBRE SUBQUERIES
-- A ATIVIDADE É PARTE INTEGRANTE DO TRABALHO 1
-- PONTUAÇÃO DISTRIBUÍDA: 10 PTS
-- PODERÁ SER REALIZADA EM DUPLAS
-- PARA CADA QUESTÃO ABAIXO, RESPONDER O QUE SE PEDE E MANTER O SCRIPT SQL CRIADO PARA ENCONTRAR A RESPOSTA
-- AO TÉRMINO DA ATIVIDADE, ENCAMINHE O SCRIPT PARA O PROFESSOR POR E-MAIL


-- IDENTIFICAÇÃO:
-- - ALUNO (A) 1:
-- - ALUNO (A) 2:

-- PREPARAÇÃO DO AMBIENTE
-- CRIE O SCHEMA ATV3
-- CRIE A TABELA ABAIXO E INSIRA OS REGISTROS À SEGUIR

-- OBS.: SERÁ UTILIZADO O MESMO AMBIENTE PROPOSTO NA PRÁTICA ANTERIOR

create table produto(
  id int,
  nome varchar(50)
)

insert into produto 
values (1, 'produto 1'),
       (2, 'produto 2'),
       (3, 'produto 3'),
       (4, 'produto 4'),
       (5, 'produto 5'),
       (6, 'produto 6'),
       (7, 'produto 7'),
       (8, 'produto 8'),
       (9, 'produto 9'),
       (10, 'produto 10'),
       (11, 'produto 11'),
       (12, 'produto 12'),
       (13, 'produto 13'),
       (14, 'produto 14'),
       (15, 'produto 15'),
       (16, 'produto 16'),
       (17, 'produto 17'),
       (18, 'produto 18'),
       (19, 'produto 19'),
       (20, 'produto 20')

create table fornecedor(
  id int, 
  nome varchar(50), 
  id_municipio int 
)

insert into fornecedor 
values (1, 'Fornecedor 1', 1),
       (2, 'Fornecedor 2', 2),
       (3, 'Fornecedor 3', 3),
       (4, 'Fornecedor 4', 4),
       (5, 'Fornecedor 5', 4)

create table municipio(
  id int,
  nome varchar(50),
  uf char(2)
)

insert into municipio 
values (1, 'São Paulo', 'SP'),
       (2, 'Porto Alegre', 'RS'),
       (3, 'Belo Horizonte', 'MG'),
       (4, 'Rio de Janeiro', 'RJ')

create table compra(
  nf int,
  id_produto int,
  id_fornecedor int,
  qtde int,
  vlr_compra numeric(12,2)
)

insert into compra 
values (1001, 12, 5, 1000, 1950),
       (1002, 14, 6, 1200, 1234),
       (1003, 1, 2, 1300, 1234),
       (1004, 3, 1, 1040, 345),
       (1005, 5, 6, 1200, 5345),
       (1006, 8, 2, 1340, 5234),
       (1007, 2, 3, 1450, 4123),
       (1008, 20, 3, 3400, 12356),
       (1009, 12, 5, 13400, 19234),
       (10010, 1, 2, 10340, 11230),
       (10011, 4, 5, 1340, 12320),
       (10012, 17, 2, 3400, 54332),
       (10013, 19, 4, 5300, 4534),
       (10014, 18, 1, 56700, 43534),
       (10015, 6, 2, 1056, 43543),
       (10016, 8, 3, 156, 345),
       (10017, 9, 4, 1450, 43555),
       (10018, 14, 3, 4500, 4345),
       (10019, 14, 3, 1500, 2345),
       (10020, 1, 2, 1060, 6534)
       
       
-- QUESTÃO 1
-- Utilizando subquery como nova coluna, apresente o nome dos produtos e o valor total comprado para cada um deles.
	
       select (select p.nome  from produto p where p.id = c.id_produto) as nome,
       sum(c.vlr_compra) as Valor
       from compra c
       group by 1
       order by 1
       
-- QUESTÃO 2
-- Utilizando subquery como nova coluna, apresente o nome dos fornecedores e a quantidade total de itens comprados de cada um deles.

	select f.nome,
	(select sum(qtde) from compra c where c.id_fornecedor = f.id) as soma
	from fornecedor f
	order by f.nome
	
-- QUESTÃO 3
-- Utilizando subquery como filtro, apresente os produtos que já foram comprados.

	select p.nome 
	from produto p
	where p.id in (select c.id_produto  from compra c where c.id_produto = p.id)
	order by p.id

-- QUESTÃO 4
-- Utilizando subquery como filtro, apresente os fornecedores que já realizaram venda.

	select f.nome 
	from fornecedor f
	where f.id in (select c.id_fornecedor from compra c where f.id = c.id_fornecedor)
       
-- QUESTÃO 5
-- Utilizando subquery como filtro, apresente os produtos que ainda não foram comprados.

    select p.nome 
	from produto p
	where p.id not in (select c.id_produto  from compra c where c.id_produto = p.id)
	order by p.id