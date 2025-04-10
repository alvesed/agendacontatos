-- drop TABLE agendacontatos;

CREATE TABLE agendacontatos
(
 id serial primary key,
 nome varchar(100) NOT NULL,
 cpf_cnpj varchar(14) DEFAULT NULL,
 ativo boolean default true,
 data_criacao TIMESTAMP,
 data_atualizacao TIMESTAMP
);

SELECT * FROM agendacontatos;