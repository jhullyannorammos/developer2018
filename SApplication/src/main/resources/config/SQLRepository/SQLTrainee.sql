create database producao;
create database desenv;
create database develop;
create database library;
create database store;
create schema homolog;
create schema producao;

use producao;
/*-----------------------------------------------------------------------------------------*/
create table store.clientes(
    codigo smallint not null auto_increment primary key,
    cpf varchar(11) not null unique,
    conta smallint,
    constraint clienteID foreign key(contaID) references clientes(codigo) 
);

create table store.conta(
   codigo smallint not null auto_increment primary key,
   saldo double
);
/*-----------------------------------------------------------------------------------------*/
create table library.editoras(
    codigo smallint not null auto_increment primary key,
    editora varchar(15) not null,
    tipo enum('nacional', 'internacional')
);
select * from library.editoras;
insert into library.editoras(editora) values('scipione');
insert into library.editoras(editora) values('Pearson ');
insert into library.editoras(editora) values('RELX Group');
insert into library.editoras(editora) values('ThomsonReuters ');
insert into library.editoras(editora) values('Bertelsmann ');
insert into library.editoras(editora) values('Wolters Kluwer');
insert into library.editoras(editora) values('scipione');
insert into library.editoras(editora) values('Hachette Livre');
insert into library.editoras(editora) values('Grupo Planeta');
insert into library.editoras(editora) values('Algaworks');
insert into library.editoras(editora) values('Allen & Unwin');
insert into library.editoras(editora) values('Saraiva');
insert into library.editoras(editora) values('Rocco');

create table library.autores(
    codigo smallint not null auto_increment primary key,
    autor varchar(30) not null
);
select * from library.autores;
insert into library.autores(autor) values('J. K. Rowling');
insert into library.autores(autor) values('J. R. R. Tolkien');
insert into library.autores(autor) values('Castro alves');
insert into library.autores(autor) values('Machado de Assis');
insert into library.autores(autor) values('Juliano Ramos');

CREATE TABLE library.categorias (
    codigo smallint not null auto_increment primary key,
    categoria VARCHAR(30) NOT NULL
);
select * from library.categorias;
insert into library.categorias(categoria) values('Folclore');
insert into library.categorias(categoria) values('Ficção');
insert into library.categorias(categoria) values('Genealogia');
insert into library.categorias(categoria) values('Biografias');
insert into library.categorias(categoria) values('Ficção Literária');
insert into library.categorias(categoria) values('Ficção Científica');
insert into library.categorias(categoria) values('Contos');

create table if not exists library.livros(
    codigo smallint not null auto_increment primary key,
    preco decimal(6,2) not null,
    livro varchar(50),
    editoraID smallint,
    categoriaID smallint,
    autorID smallint,
    constraint fk_editora_livro foreign key(editoraID) references editoras(codigo) on update cascade,
    constraint fk_autor_livro foreign key(autorID) references autores(codigo) on update cascade,
    constraint fk_categoria_livro foreign key(categoriaID) references categorias(codigo) on delete set null 
);
drop table library.livros;
select livro, preco, editora, autor, categoria from library.livros 
       join library.categorias 
       join library.editoras 
       join library.autores 
       on editoras.codigo = livros.editoraID 
       and autores.codigo = livros.autorID
       and categorias.codigo = livros.categoriaID
       where livros.codigo = 1;
select livro, preco, editora, autor, categoria from library.livros 
       join library.categorias 
       join library.editoras 
       join library.autores 
       on editoras.codigo = livros.editoraID 
       and autores.codigo = livros.autorID
       and categorias.codigo = livros.categoriaID;
insert into library.livros(livro, preco, editoraID, autorID, categoriaID) values("O Hobbit e a desolação de Smaug", 150.0, 12, 4, 2);
insert into library.livros(livro, preco, editoraID, autorID, categoriaID) values("Harry Potter e a Camara secreta", 100.0, 13, 2, 2);
insert into library.livros(livro, preco, editoraID, autorID, categoriaID) values("Harry Potter e a Ordem da Fenix", 100.0, 13, 2, 2);
insert into library.livros(livro, preco, editoraID, autorID, categoriaID) values("Harry Potter e as reliquias da morte", 100.0, 13, 2, 2);
/*-----------------------------------------------------------------------------------------*/
create table library.itens(
       codigo smallint not null auto_increment primary key,
       livroID smallint,
       constraint fk_item_livro foreign key(livroID) references livros(codigo)
);
create table library.locacao(
       codigo smallint not null auto_increment primary key,
       itemID smallint,
       retirada TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       entrega datetime,
       preco double,
       periodo enum('DIARIA', 'SEMANAL'),
       constraint fk_loc_item foreign key(itemID) references itens(codigo)
);
/*---------------------------------------------------------------------------------------*/
/* CRIANDO VIEWS DE LIVROS */
select * from library.visualizador2;
select * from library.visualizador;
CREATE VIEW library.visualizador2 as
       SELECT codigo, livro from library.livros;
       SELECT * FROM library.livros LIMIT 2;

/*---------------------------------------------------------------------------------------*/

DELIMITER $$
CREATE TRIGGER entradaItem AFTER UPDATE
ON library.itens
FOR EACH NOW
BEGIN
    UPDATE library.estoque SET estoque = estoque + 1 WHERE modeloID = ;
END 
$$ DELIMITER ;

DELIMITER $$
CREATE TRIGGER entregaItem AFTER UPDATE
ON library.itens
FOR EACH NOW
BEGIN
    UPDATE library.estoque SET estoque = estoque - 1 WHERE modeloID = ;
END 
$$ DELIMITER ;
/*--------------------------------------------------------------------------------------*/
/* CRIANDO PROCEDURES NO DATABASE */
CALL library.ListarLivros(2) ;

SET @valor = 5;
CALL library2.ElevarQuadrado(@valor);
SELECT @valor;

call library.ListarQuantidadeLivros(@total); select @total;

DELIMITER $$
   CREATE PROCEDURE library2.ElevarQuadrado(INOUT numero INT)
   BEGIN
      SET numero = numero * numero;
   END
$$ DELIMITER ;

DELIMITER $$
CREATE PROCEDURE library.ListarQuantidadeLivros(OUT quantidade INT) 
BEGIN
	SELECT COUNT(*) INTO quantidade FROM library.livros;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE library.ListarLivros(IN quantidade INT) 
BEGIN
	SELECT * FROM library.livros LIMIT quantidade;
END $$
DELIMITER ;