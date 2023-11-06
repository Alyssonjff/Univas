-- Criar Database
create schema atividade01;

-- Verificar todos os schemas
show schemas;

-- Criar tabela
create table if not exists atividade(
  id int auto_increment primary key,
  dt_atendimento date,
  atendido char(1),
  resolvido char(1),
  tempo_atendimento int,
  indice_satisfacao int
)

-- Para excluir tabela criada
drop table if exists atividade


-- Inserir os valores da tabela
insert into atividade (dt_atendimento, atendido, resolvido,
                       tempo_atendimento, indice_satisfacao)
  values ('2022-12-03','T','T',221,9),  
         ('2022-12-05','F','F',443,8), 
         ('2022-12-06','T','T',213,9),
         ('2022-01-13','T','T',456,7),
         ('2022-01-15','T','T',4564,6),
         ('2022-01-03','F','F',3456,5),
         ('2023-02-12','T','F',356,3),
         ('2023-02-22','T','T',456,5),
         ('2023-02-28','T','T',567,6),
         ('2023-03-01','T','T',8987,7),
         ('2023-03-02','F','F',567,8),
         ('2023-03-02','T','T',345,9),
         ('2023-02-02','T','T',234,10),
         ('2023-02-03','T','T',2234,1),
         ('2023-02-13','F','F',345,3),
         ('2023-02-09','T','F',456,2),
         ('2022-11-03','T','F',7568,5),
         ('2022-11-19','T','T',5675,7),
         ('2022-11-17','T','T',4564,8),
         ('2022-11-30','T','T',3455,9)
	
-- Verificar dados da tabela
select * from atividade 

-- 1 Qual o índice médio de satisfação alcançado pela instituição?
	select avg(indice_satisfacao) as "Índice Médio de Satisfação"
	from atividade
	
-- 2 Qual o tempo total de atendimentos realizados?
	select sum(tempo_atendimento) as "Tempo Total de Atendimento"
	from atividade
	
-- 3 Considerando que cada tupla representa um atendimento, qual o total de atendimentos realizados?
	select count(*) as "Total de Atendimentos"
	from atividade
	
-- 4 Qual o total de atendimentos realizados por ano? Para resolver essa questão, pesquise sobre a função extract.
	SELECT EXTRACT(YEAR FROM dt_atendimento) as "Ano",
       COUNT(*) as "Total de Atendimentos"
	FROM atividade
	GROUP BY Ano

-- 5 Qual o índice médio de satisfação por ano?
	SELECT EXTRACT(YEAR FROM dt_atendimento) as "Ano",
       AVG(indice_satisfacao) as "Índice Médio de Satisfação"
	FROM atividade
	GROUP BY Ano

-- 6 Qual o tempo médio de atendimento por ano?
	SELECT EXTRACT(YEAR FROM dt_atendimento) as "Ano",
       AVG(tempo_atendimento) as "Tempo Médio de Atendimento"
	FROM atividade
	GROUP BY Ano

-- 7 A coluna atendido indica se o cliente foi atendido (T) ou não (F). Crie uma 
-- consulta que indique o total de atendimentos, o tempo médio de atendimento e 
-- o índice médio de satisfação por status de atendimento.
select 
atendido as "STATUS",
    count(*) as "Total de Atendimentos",
    avg(tempo_atendimento) as "Tempo Médio de Atendimento",
    avg(indice_satisfacao) as "Índice Médio de Satisfação"
from atividade
group by 1

-- 8  Repita a consulta anterior separando os dados também por ano.
select
    extract (year from dt_atendimento) as "Ano",
    atendido as "STATUS",
    count(*) as "Total de Atendimentos",
    avg(tempo_atendimento) as "Tempo Médio de Atendimento",
    avg(indice_satisfacao) as "Índice Médio de Satisfação"
from atividade
group by 1,2

-- 9 Qual o maior e o menor índice de satisfação alcançados para os atendimentos em 2023?
select max(indice_satisfacao) as "Maior Índice de Satisfação",
       min(indice_satisfacao) as "Menor Índice de Satisfação"
from atividade
where extract(year from dt_atendimento) = 2023
	
-- 10 Qual a média de índice de satisfação para atendimentos em que os casos foram resolvidos (T) ou não (F)?
select 
atendido,
avg(indice_satisfacao)
from atividade
group by 1