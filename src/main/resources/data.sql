CREATE TABLE user (
	id bigint PRIMARY KEY auto_increment,
	name varchar(200),
	email varchar(200),
	password varchar(200)
);

INSERT INTO user (name, email, password) VALUES
('Julio Cesar', 'julio.cesar14@email.com', 'julio12345'),
('Maria Fernandez', 'mahfe@email.com', 'maria54321'),
('Juliana Martins', 'jumartins@email.com', 'ju1236754');

CREATE TABLE address (
	id bigint PRIMARY KEY auto_increment,
	endereco varchar(200),
	email varchar(200),
	cidade varchar(200),
	cep varchar(200),
	numero varchar(200)
);

INSERT INTO address (endereco, email, cidade, cep, numero) VALUES
('Rua Javali do Mato', 'VilaJavaliPark@email.com', 'SP', '61492857', '410'),
('Rua Viva Lavida', 'VivaAptos@email.com', 'SP', '04974863', '1240'),
('Rua Tangerinas', 'CitrusPark@email.com', 'RJ', '07962809', '950');