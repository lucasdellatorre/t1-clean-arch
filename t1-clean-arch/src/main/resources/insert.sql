INSERT INTO clientes (nome, email) VALUES ('Cliente 1', 'cliente1@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 2', 'cliente2@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 3', 'cliente3@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 4', 'cliente4@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 5', 'cliente5@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 6', 'cliente6@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 7', 'cliente7@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 8', 'cliente8@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 9', 'cliente9@example.com');
INSERT INTO clientes (nome, email) VALUES ('Cliente 10', 'cliente10@example.com');

INSERT INTO aplicativos (nome, custo_mensal) VALUES ('app 1', 10.0);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('app 2', 20.0);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('app 3', 40.0);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('app 4', 50.0);
INSERT INTO aplicativos (nome, custo_mensal) VALUES ('app 5', 99.99);

INSERT INTO assinaturas (codigo_aplicativo, codigo_cliente, data_inicio, data_expiracao)
VALUES
    ((SELECT codigo FROM aplicativos WHERE nome = 'app 1'), (SELECT codigo FROM clientes WHERE nome = 'Cliente 1'), '2023-05-01', '2025-06-01'),
    ((SELECT codigo FROM aplicativos WHERE nome = 'app 1'), (SELECT codigo FROM clientes WHERE nome = 'Cliente 2'), '2023-05-01', '2025-06-01'),
    ((SELECT codigo FROM aplicativos WHERE nome = 'app 1'), (SELECT codigo FROM clientes WHERE nome = 'Cliente 3'), '2023-05-01', '2023-06-01');

INSERT INTO assinaturas (codigo_aplicativo, codigo_cliente, data_inicio, data_expiracao)
VALUES
    ((SELECT codigo FROM aplicativos WHERE nome = 'app 2'), (SELECT codigo FROM clientes WHERE nome = 'Cliente 4'), '2023-05-01', '2023-06-01'),
    ((SELECT codigo FROM aplicativos WHERE nome = 'app 2'), (SELECT codigo FROM clientes WHERE nome = 'Cliente 5'), '2023-05-01', '2023-06-01'),
    ((SELECT codigo FROM aplicativos WHERE nome = 'app 2'), (SELECT codigo FROM clientes WHERE nome = 'Cliente 6'), '2023-05-01', '2025-06-01');
