-- Criar Database
create schema aula01;

-- Verificar todos os schemas
show schemas;

-- Criar tabela
create table vendas(
  nf int primary key,
  cod_produto int,
  nome_produto varchar(50),
  qtd_vendida int,
  vlr_desconto numeric(12,2),
  vlr_total numeric(12,2)
)

-- Inserir os valores da tabela
insert into vendas values 
  (1,101,'camisa',2,40,260),
  (2,102,'calça',3,90,699),
  (3,103,'jaqueta',1,40,499),
  (4,104,'sapato',1,30,389)
  
-- 1 maior valor de venda
  select max(vlr_total)
  from vendas 
  
-- 2 maior quantidade de venda
  select max(qtd_vendida)
  from vendas 
  
-- 3 maior desconto de venda
  select max(vlr_desconto)
  from vendas 
  
-- tudo junto
  select max(vlr_total) as "Valor Total",
    max(qtd_vendida) as "Qtd. Vendida",
    max(vlr_desconto) as "Valor Desconto"
  from vendas 

-- 4 menor valor de venda
  select min(vlr_total)
  from vendas 
  
-- 5 menor quantidade vendida 
  select min(qtd_vendida)
  from vendas
  
-- 6 menor valor de desconto 
  select min(vlr_desconto)
  from vendas
  
-- tudo junto
  select min(vlr_total) as "Menor Venda",
    min(qtd_vendida) as "Menor Quantidade",
    min(vlr_desconto) as "Menor Desconto"
  from vendas 
  
-- 7 Valor total das vendas
  select sum(vlr_total)
  from vendas 
  
-- 8 Total de quantidade vendida
  select sum(qtd_vendida)
  from vendas 
  
-- 9 Valor total de desconto 
  select sum(vlr_desconto)
  from vendas 
  
-- tudo junto
  select sum(vlr_total) as "Valor Total Vendido",
    sum(qtd_vendida) as "Total de Quantidade Vendida",
    sum(vlr_desconto) as "Valor Total de Desconto"
  from vendas 
  
-- 10 Valor médio das vendas 
  select avg(vlr_total)
  from vendas 
  
-- 11 Quantidade média vendida 
  select avg(qtd_vendida)
  from vendas 
  
-- 12 Média de descontos
  select avg(vlr_desconto)
  from vendas 
  
-- tudo junto
  select avg(vlr_total) as "Média das Vendas",
    avg(qtd_vendida) as "Média de Quantidade",
    avg(vlr_desconto) as "Média de Descontos"
  from vendas 
  
-- 13 Quantas vendas foram realizadas
  select count(*)
  from vendas 
  
-- 14 Quantas vendas de jaquetas (103)
  select count(*)
  from vendas 
  where cod_produto = 103
  
-- 15 Quantas vendas de sapato (104)
  select count(*)
  from vendas 
  where cod_produto = 104
  
-- extra: Quantas vendas de sapato e jaqueta
  select count(*)
  from vendas 
  where cod_produto in(103,104)
  
-- 16 Total de vendas, qtd e desconto por produto 
  select nome_produto,
    sum(vlr_total) as "Valor Total",
    sum(qtd_vendida) as "Quantidade Total",
    sum(vlr_desconto) as "Desconto Total"
  from vendas 
  group by 1