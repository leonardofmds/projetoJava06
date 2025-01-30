CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE ESTOQUE(
	id UUID PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
);


CREATE TABLE PRODUTO(
	id UUID PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	preco DECIMAL(10,2) NOT NULL check(preco>0),
	quantidade INT NOT NULL CHECK(quantidade>0),
	estoque_id UUID NOT NULL,
	FOREIGN KEY(estoque_id) REFERENCES estoque(id);
);