
/* testando a tabela administradores */
create table application.administradores(
   codigo SMALLINT not null auto_increment PRIMARY KEY,
   username varchar(20),
   passwd varchar(8),
   nome VARCHAR(25),
   perfil ENUM('administrador', 'root', 'master', 'supporte')
);
insert into application.administradores(codigo, username, passwd, perfil) values(1, "root", "123abc", "suporte");
insert into application.administradores(codigo, username, passwd, perfil) values(2, "adm", "abc123", "adm");
select * from application.administradores;

/* tabela de autores */
CREATE TABLE application.autores (
    codigo SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    autor VARCHAR(10) NOT NULL
);
select * from application.autores;
drop table application.autores;
insert into application.autores(codigo, autor) values(1, "JK Rowling");
insert into application.autores(codigo, autor) values(2, "Thiago Faria");
/* tabela de editoras */
CREATE TABLE application.editoras (
codigo SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
editora VARCHAR(15) NOT NULL
);
insert into application.editoras(codigo, editora) values(1, "Scipione");
insert into application.editoras(codigo, editora) values(2, "Ficção");
insert into application.editoras(codigo, editora) values(3, "Sextante");
insert into application.editoras(codigo, editora) values(3, "Algaworks");

CREATE TABLE application.categorias (
codigo SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
categoria VARCHAR(30) NOT NULL
);
insert into application.categorias(codigo, categoria) values(1, "Livros");
insert into application.categorias(codigo, categoria) values(2, "Informática");
/*   */
CREATE TABLE IF NOT EXISTS application.livros (
codigo SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
livro VARCHAR(70) NOT NULL,
id_categoria SMALLINT,
id_editora SMALLINT NOT NULL,
id_autor SMALLINT NOT NULL,
publicacao DATE NOT NULL,
preco DECIMAL(6,2) NOT NULL
);

ALTER TABLE application.livros
MODIFY COLUMN codigo SMALLINT;

ALTER TABLE application.livros
ADD  id_autor  SMALLINT NOT NULL;

ALTER TABLE application.livros
ADD  id_editora  SMALLINT NOT NULL;

ALTER TABLE application.livros
ADD  id_categoria  SMALLINT NOT NULL;

ALTER TABLE application.livros
ADD CONSTRAINT fk_ID_editora
FOREIGN KEY (id_editora)
REFERENCES editoras (codigo)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE application.livros
ADD CONSTRAINT fk_ID_autor
FOREIGN KEY (id_autor)
REFERENCES autores (codigo)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE application.livros
ADD CONSTRAINT fk_ID_categoria
FOREIGN KEY (id_categoria)
REFERENCES categorias (codigo)
ON DELETE CASCADE
ON UPDATE CASCADE;