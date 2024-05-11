DROP TABLE clientes IF EXISTS;
CREATE TABLE clientes (
    codigo IDENTITY NOT NULL PRIMARY KEY, 
    nome VARCHAR(255),
    email VARCHAR(255),
);