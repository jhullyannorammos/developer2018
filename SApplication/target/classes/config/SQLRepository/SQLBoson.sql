/*
backup do banco application
mysqldump -u root -p application > /home/julianno/application.sql

restore database
mysql -u root -p kaon < backup.sql
mysql -y root -p restore-db < /home/julianno/application.sql
*/
/*===============================================================================================================================================*/

/*===============================================================================================================================================*/
CREATE VIEW vw_LivrosAutores AS SELECT library.livros.Nome_Livro AS Livro, library.autores.Nome_Autor AS Autor FROM library.livros INNER JOIN library.autores ON library.livros.ID_Autor = library.autores.ID_Autor;
SELECT Livro, Autor FROM vw_LivrosAutores ORDER BY Autor;
ALTER  VIEW vw_LivrosAutores AS SELECT library.livros.Nome_Livro AS Livro, library.autores.Nome_Autor AS Autor, Preco_Livro AS Valor FROM library.livros INNER JOIN library.autores ON library.livros.ID_Autor = library.autores.ID_Autor;
SELECT * FROM vw_LivrosAutores;
DROP VIEW vw_LivrosAutores;
/*===============================================================================================================================================*/
create function funcao (a decimal(10, 2), b int) returns INT 
return a * b;

create function calculaLocacao(a decimal(10, 2), b int) returns int 
return a * b;
select calculaLocacao(2.5, 10) as resultado;
select nome, calculaLocacao(preco, 6) as 'Preço de 06 unidades' from library.livros where livros.codigo = 3;

create function view_preco(a smallint) 
returns varchar(20)
return (select concat('O PREÇO DO LIVRO', LIVRO, ' EH ', PRECO) from library.livros where codigo = a);

SELECT view_preco(3);
/*==========================================================================================================================================================================*/
SELECT L.NomeLivro Livro, L.PrecoLivro 'Preço Normal', L.PrecoLivro * 0.90 'Preço Ajustado', A.Assunto FROM library.livross L INNER JOIN tbl_Assuntos A ON L.IdAssunto = A.IdAssunto WHERE L.PrecoLivro > 200.00
UNION
SELECT L.NomeLivro Livro, L.PrecoLivro 'Preço Normal', L.PrecoLivro * 1.15 'Preço Ajustado', A.Assunto FROM library.livross L INNER JOIN tbl_Assuntos A ON L.IdAssunto = A.IdAssunto WHERE A.Assunto = 'Eletrônica' ORDER BY 'Preço Ajustado' DESC;

SELECT NomeLivro Livro, PrecoLivro Preço, 'Livro Caro' Resultado FROM library.livross WHERE PrecoLivro >= 150.00
UNION
SELECT NomeLivro Livro, PrecoLivro Preço, 'Preço Razoável' Resultado FROM library.livross WHERE PrecoLivro < 150.00 ORDER BY Preço;

SELECT * FROM tbl_Assuntos LEFT JOIN library.livross ON library.livross.IdAssunto = tbl_Assuntos.IdAssunto
UNION
SELECT * FROM tbl_Assuntos RIGHT JOIN library.livross ON library.livross.IdAssunto = tbl_Assuntos.IdAssunto;
/*==========================================================================================================================================================================*/
SELECT L.Nome_Livro AS Livros, E.Nome_editora AS Editoras FROM library.livros AS L INNER JOIN library.editoras AS E ON L.ID_editora = E.ID_editora WHERE E.Nome_Editora LIKE 'M%';
SELECT * FROM library.livros INNER JOIN library.autores ON library.livros.ID_Autor = library.autores.ID_Autor; 
SELECT library.livros.Nome_Livro, library.livros.ISBN, library.autores.Nome_Autor FROM library.livros INNER JOIN library.autores ON library.livros.ID_Autor = library.autores.ID_Autor;
SELECT L.Nome_Livro AS Livro, A.Nome_autor AS Autor, E.Nome_Editora AS Editora, L.Preco_Livro AS 'Preço do Livro' FROM library.livros AS L INNER JOIN library.autores AS A ON L.ID_autor = A.ID_autor INNER JOIN library.editoras AS E ON L.ID_editora = E.ID_editora WHERE E.Nome_Editora LIKE 'O%' ORDER BY L.Preco_Livro DESC;
SELECT * FROM library.livros RIGHT JOIN library.editoras ON library.livros.ID_editora = library.editoras.ID_editora WHERE library.livros.ID_editora IS NULL;
SELECT * FROM library.livros AS Li RIGHT JOIN library.editoras AS Ed ON Li.ID_editora = Ed.ID_editora;
SELECT * FROM library.autores LEFT JOIN library.livros ON library.livros.ID_Autor = library.autores.ID_Autor;
SELECT * FROM library.autores LEFT JOIN library.livros ON library.livros.ID_Autor = library.autores.ID_Autor WHERE library.livros.ID_Autor IS NULL;
SELECT Nome_Livro, Preco_Livro FROM library.livros CROSS JOIN library.autores;
/*==========================================================================================================================================================================*/
SELECT Nome_Livro FROM library.livros WHERE Nome_Livro REGEXP '^[FS]';
SELECT Nome_Livro FROM library.livros WHERE Nome_Livro REGEXP '^[^FS]';
SELECT Nome_Livro FROM library.livros WHERE Nome_Livro REGEXP '[ng]$';
SELECT Nome_Livro FROM library.livros WHERE Nome_Livro REGEXP '^[FS]|Mi';
/*==========================================================================================================================================================================*/
CREATE TABLE calc_mult (
  ID SMALLINT PRIMARY KEY AUTO_INCREMENT,
  num1 SMALLINT NOT NULL,
  num2 SMALLINT NOT NULL,
  num3 SMALLINT GENERATED ALWAYS AS (num1 * num2) VIRTUAL
);
/*==========================================================================================================================================================================*/
CREATE TABLE library.locacao (
 codigo SMALLINT PRIMARY KEY AUTO_INCREMENT,
 Preco_Produto DECIMAL(6,2) NOT NULL,
 Qtde TINYINT NOT NULL,
 Desconto DECIMAL(4,2) NOT NULL,
 Preco_Total DECIMAL(6,2) AS (Preco_Produto * Qtde * (1 - Desconto / 100)) STORED
);
/*==========================================================================================================================================================================*/
SELECT Cidade, SUM(Quantidade) As Total FROM Vendas GROUP BY Cidade HAVING SUM(Quantidade) < 2500;
SELECT Cidade, SUM(Quantidade) As TotalTeclados FROM Vendas WHERE Produto = 'Teclado' GROUP BY Cidade HAVING SUM(Quantidade) < 1500;
/*==========================================================================================================================================================================*/
SELECT * FROM application.mercadorias WHERE NOME LIKE 'F%';
SELECT * FROM application.mercadorias WHERE NOME NOT LIKE 'F%';
SELECT * FROM application.mercadorias where preco BETWEEN  10.00 AND 1000.00;
/*==========================================================================================================================================================================*/
SELECT COUNT(*) FROM application.mercadorias where preco > 100.0;
SELECT COUNT(DISTINCT codigo) FROM application.mercadorias;
/*==========================================================================================================================================================================*/
SELECT MIN(dataVenda) FROM application.mercadorias;
SELECT AVG(preco) FROM application.mercadorias GROUP BY categoria = 'GAMES';
SELECT SUM(preco) FROM application.mercadorias GROUP BY categoria = 'ELETRÔNICOS';
/*==========================================================================================================================================================================*/
SELECT CONCAT('Juliano', ' Ramos') AS 'myName';
SELECT CONCAT(codigo, '', autor) AS 'myName' from library.autores;
SELECT CONCAT('EU GOSTO DO LIVRO : ', NOME_LIVRO) FROM library.autores WHERE codigo = 3;
SELECT CONCAT('A quantidade adquirida é ', ' ', IFNULL(quantidade, 0)) FROM teste_nulos WHERE  item = 'Teclado';
SELECT CONCAT('A quantidade adquirida é ', ' ', COALESCE(NULL, quantidade, NULL, 0)) FROM teste_nulos WHERE  item = 'Teclado';
/*==========================================================================================================================================================================*/
RENAME TABLE clientes TO myclientes;

CREATE TABLE contatos (
  codigo TINYINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(25),
  categoria ENUM('Familia','Amigos','Profissional','Outros')
);

CREATE TABLE pedidos (
  codigo SMALLINT PRIMARY KEY AUTO_INCREMENT,
  produto ENUM ('Computador', 'Servidor'),
  manutencao SET ('Preventiva','Corretiva')
);
/*==========================================================================================================================================================================*/
SHOW CREATE TABLE library.autores;
SHOW CREATE PROCEDURE verpreço;
SHOW CREATE FUNCTION calcula_desconto;

SHOW FULL COLUMNS FROM library.livros;
SHOW FULL COLUMNS FROM library.editoras;
SHOW COLUMNS FROM library.livros LIKE 'C%';
SHOW COLUMNS FROM library.livros WHERE Type like 'varchar%';
SHOW GRANTS FOR root@localhost;

SHOW COLUMNS FROM library.livros;
DESCRIBE library.livros;

SHOW DATABASES;
use application;
SHOW TABLES;








