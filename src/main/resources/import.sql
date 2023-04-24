INSERT INTO cozinha (id, nome)
VALUES (1, 'Tailandesa');
INSERT INTO cozinha (id, nome)
VALUES (2, 'Mexicana');
INSERT INTO cozinha (id, nome)
VALUES (3, 'Brasileira');
INSERT INTO restaurante (nome, taxa_frete, cozinha_id)
VALUES ('Jack Gourmet', 10, 3);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id)
VALUES ('Tai Nachos', 8, 2);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id)
VALUES ('X-Bacon do Bola', 5, 1);
INSERT INTO forma_pagamento (descricao)
VALUES ('Cartão de Crédito');
INSERT INTO forma_pagamento (descricao)
VALUES ('Cartão de Débito');
INSERT INTO forma_pagamento (descricao)
VALUES ('Pix');
INSERT INTO forma_pagamento (descricao)
VALUES ('Dinheiro');
INSERT INTO permissao (nome, descricao)
VALUES ('Listar Cozinhas', 'Permite Listar as Cozinhas');
INSERT INTO estado (nome)
VALUES ('Santa Catarina');
INSERT INTO estado (nome)
VALUES ('Distrito Federal');
INSERT INTO cidade (nome, estado_id)
VALUES ('Coronel Freitas', 1);
INSERT INTO cidade (nome, estado_id)
VALUES ('Brasília', 2);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (2, 3),
       (3, 2),
       (3, 3);
