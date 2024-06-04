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
    custo_mensal NUMERIC(6, 2)
);

CREATE TABLE assinaturas (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    codigo_aplicativo INT,
    codigo_cliente INT,
    data_inicio DATE,
    data_expiracao DATE,
    FOREIGN KEY (codigo_aplicativo) REFERENCES aplicativos(codigo),
    FOREIGN KEY (codigo_cliente) REFERENCES clientes(codigo)
);