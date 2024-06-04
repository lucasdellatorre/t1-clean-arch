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

INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (1, 'app 1', 10.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (2, 'app 2', 20.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (3, 'app 3', 40.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (4, 'app 4', 50.0);
INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES (5, 'app 5', 99.99);

INSERT INTO assinatura (fim_vigencia, inicio_vigencia, aplicativo_codigo, cliente_codigo, codigo) VALUES ('2024-06-04', '2024-07-04', 1, 1, 1);
INSERT INTO assinatura (fim_vigencia, inicio_vigencia, aplicativo_codigo, cliente_codigo, codigo) VALUES ('2024-06-04', '2024-07-04', 2, 2, 2);
INSERT INTO assinatura (fim_vigencia, inicio_vigencia, aplicativo_codigo, cliente_codigo, codigo) VALUES ('2024-06-04', '2024-07-04', 3, 3, 3);

INSERT INTO assinatura (fim_vigencia, inicio_vigencia, aplicativo_codigo, cliente_codigo, codigo) VALUES ('2024-06-02', '2024-07-04', 4, 4, 4);
INSERT INTO assinatura (fim_vigencia, inicio_vigencia, aplicativo_codigo, cliente_codigo, codigo) VALUES ('2024-06-02', '2024-07-04', 5, 5, 5);