-- https://h2database.com/html/grammar.html

DROP TABLE clientes IF EXISTS;
CREATE TABLE clientes (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE aplicativos (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    custoMensal NUMERIC(6, 2)
);