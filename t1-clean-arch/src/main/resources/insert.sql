INSERT INTO cliente (codigo, nome, email) VALUES (1, 'Cliente 1', 'cliente1@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (2, 'Cliente 2', 'cliente2@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (3, 'Cliente 3', 'cliente3@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (4, 'Cliente 4', 'cliente4@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (5, 'Cliente 5', 'cliente5@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (6, 'Cliente 6', 'cliente6@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (7, 'Cliente 7', 'cliente7@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (8, 'Cliente 8', 'cliente8@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (9, 'Cliente 9', 'cliente9@example.com');
INSERT INTO cliente (codigo, nome, email) VALUES (10, 'Cliente 10', 'cliente10@example.com');

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
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (1, 'app 1', 10.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (2, 'app 2', 20.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (3, 'app 3', 40.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (4, 'app 4', 50.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (5, 'app 5', 99.99);
