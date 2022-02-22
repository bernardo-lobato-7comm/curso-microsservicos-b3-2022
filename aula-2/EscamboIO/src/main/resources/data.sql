INSERT INTO TB_ROLE (authority) VALUES  ('ROLE_CLIENTE');
INSERT INTO TB_ROLE (authority) VALUES  ('ROLE_VENDEDOR');

INSERT INTO TB_CLIENTES (nome, email, password, cpf, role_id) VALUES ('Alberto', 'alberto@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', '341.295.600-77',1);
INSERT INTO TB_VENDEDORES (nome, email, password, empresa, site_comercial, CNPJ, role_id) VALUES ('Jose','jose@gmail.com','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'LivrosOnline','livrosonline.com.br','08.895.277/0001-31',2);


INSERT INTO TB_ENDERECO(bairro, cep, logradouro, numero, cliente_id) VALUES ('Alto José do Pinho', '52210-064', '2ª Travessa Horácio Silva', '935', 1);

INSERT INTO TB_PRODUTO(nome, preco, quantidade_em_stock, vendedor_id) VALUES ('TV', 1000.00, 5, 1);
INSERT INTO TB_PRODUTO(nome, preco, quantidade_em_stock, vendedor_id) VALUES ('Geladeira', 3000.00, 2, 1);
INSERT INTO TB_PRODUTO(nome, preco, quantidade_em_stock, vendedor_id) VALUES ('Sofá', 500.00, 10, 1);

INSERT INTO TB_PEDIDO(date, comprador_id, endereco_id) VALUES (TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 1, 1);
INSERT INTO TB_PEDIDO(date, comprador_id, endereco_id) VALUES (TIMESTAMP WITH TIME ZONE '2020-07-15T15:20:17.12345Z', 1, 1);

INSERT INTO TB_ITEM_PEDIDO(preco, quantidade, produto_id, pedido_id) VALUES (1000.0, 2, 1, 1);
INSERT INTO TB_ITEM_PEDIDO(preco, quantidade, produto_id, pedido_id) VALUES (3000.0, 1, 2, 2);