CREATE DATABASE noorden;
USE noorden;

CREATE TABLE cliente (
  cliente_id bigint(20) NOT NULL AUTO_INCREMENT,
  cpf varchar(11) NOT NULL UNIQUE,
  data_nasc varchar(10) NOT NULL,
  nome varchar(75) NOT NULL,
  sexo varchar(1) NOT NULL,
  PRIMARY KEY (cliente_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE produto (
  produto_id bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(75) NOT NULL,
  valor double NOT NULL,
  PRIMARY KEY (produto_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE venda (
  venda_id bigint(20) NOT NULL AUTO_INCREMENT,
  cod_cliente bigint(20) NOT NULL,
  cod_produto bigint(20) NOT NULL,
  valor_total double NOT NULL,
  PRIMARY KEY (venda_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Claudio Almeida Martins", "36788818827", "1986-12-18", "M");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Marcio Anselmo", "75991094047", "1998-01-08", "M");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Luzenilde Silva Martins", "28380264029", "1987-01-25", "F");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Roberto Alves ", "87168157000", "1999-02-28", "M");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Nicolas Cage", "93976984000", "1977-07-05", "M");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Fernanda Lima Silva", "09229235075", "1992-05-21", "F");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Antonio Carlos Evaristo", "05646276071", "1996-08-06", "M");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Matheus Castro Alexandre", "68969467092", "2003-04-25", "M");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Rose Garcia", "38600999065", "1982-12-29", "F");
INSERT INTO cliente (nome, cpf, data_nasc, sexo) VALUES ("Felipe Abravanel Souza", "31705820034", "1988-09-21", "M");

INSERT INTO produto (nome, valor) VALUES ("Violão", 439.90);
INSERT INTO produto (nome, valor) VALUES ("Guitarra", 805.50);
INSERT INTO produto (nome, valor) VALUES ("Bateria", 1599.00);
INSERT INTO produto (nome, valor) VALUES ("Baixo", 584.97);
INSERT INTO produto (nome, valor) VALUES ("Teclado", 799.90);
INSERT INTO produto (nome, valor) VALUES ("Flauta", 864.90);
INSERT INTO produto (nome, valor) VALUES ("Violino", 168.99);
INSERT INTO produto (nome, valor) VALUES ("Piano", 3890.50);
INSERT INTO produto (nome, valor) VALUES ("Trompete", 232.71);
INSERT INTO produto (nome, valor) VALUES ("Cavaquinho", 208.91);