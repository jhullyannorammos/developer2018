create database gscom;
show databases;
drop database gscom;
use gscom;

create table gscom.comivenda(
      n_numeivenda int not null auto_increment,
      n_numevenda int not null,
      n_numeprodu int not null,
      n_valoivenda float(10,2),
      n_qtdeivenda int,
      n_descivenda float(10, 2),
      primary key(n_numeivenda)
);
/* ----------------------------------------------------------------- */
create table gscom.comvendas(
n_numevenda int not null auto_increment,
c_codivenda varchar(10),
n_numeclien int not null,
n_numeforne int not null,
n_numevende int not null,
n_valovenda float(10,2),
n_descvenda float(10,2),
n_totavenda float(10,2),
d_datavenda date,
primary key(n_numevenda));
/* ----------------------------------------------------------------- */
create table gscom.comforne(
	n_numeforne int not null auto_increment,
    c_codiforne varchar(10),
    c_nomeforne varchar(100),
    c_razaforne varchar(100),
    c_foneforne varchar(20),
    primary key(n_numeforne)
);
/* ----------------------------------------------------------------- */
create table gscom.comvenda(
n_numevenda int not null auto_increment,
c_codivenda varchar(10),
n_numeclien int not null,
n_numeforne int not null,
n_numevende int not null,
n_valovenda float(10,2),
n_descvenda float(10,2),
n_totavenda float(10,2),
d_datavenda date,
primary key(n_numevenda));
/* ----------------------------------------------------------------- */
create table gscom.comvende(
      n_numevende int not null auto_increment,
      c_codivende varchar(10),
      c_nomevende varchar(100),
      c_razavende varchar(100),
      c_fonevende varchar(20),
      n_porcvende float(10,2),
primary key(n_numevende));
/* ----------------------------------------------------------------- */
create table gscom.comprodu(
n_numeprodu int not null auto_increment,
c_codiprodu varchar(20),
c_descprodu varchar(100),
n_valoprodu float(10,2),
c_situprodu varchar(1),
n_numeforne int,
primary key(n_numeprodu));
/* ----------------------------------------------------------------- */
create table gscom.comclien(
n_numeclien int not null auto_increment,
c_codiclien varchar(10),
c_nomeclien varchar(100),
c_razaclien varchar(100),
d_dataclien date,
c_cnpjclien varchar(20),
c_foneclien varchar(20),
primary key (n_numeclien));

ALTER TABLE gscom.comclien AUTO_INCREMENT=100;
alter table comclien add column c_cidaclien varchar(50);
alter table comclien drop column c_estclien;

alter table gscom.comvenda add constraint fk_comprodu_comforne
foreign key(n_numeforne)
references comforne(n_numeforne)
on delete no action
on update no action;
/* ----------------------------------------------------------------- */
alter table gscom.comvenda add constraint fk_comprodu_comvende
foreign key(n_numevende)
references comvende(n_numevende)
on delete no action
on update no action;
/* ----------------------------------------------------------------- */
alter table comvenda add constraint fk_comprodu_comvende
foreign key(n_numevende)
references comvende(n_numevende)
on delete no action
on update no action;
/* ----------------------------------------------------------------- */
alter table comvenda add constraint fk_comvenda_comclien
foreign key(n_numeclien)
references comclien(n_numeclien)
on delete no action
on update no action;
/* ----------------------------------------------------------------- */
alter table comivenda add constraint fk_comivenda_comprodu
foreign key(n_numeprodu)
references comprodu (n_numeprodu)
on delete no action
on update no action;
/* ----------------------------------------------------------------- */
alter table comvenda add constraint fk_comvenda_comclien
foreign key(n_numeclien)
references comclien(n_numeclien)
on delete no action
on update no action;
/* ----------------------------------------------------------------- */
alter table comivenda add constraint fk_comivenda_comvenda
foreign key(n_numevenda)
references comvenda (n_numevenda)
on delete no action
on update no action;
/* ----------------------------------------------------------------- */
alter table comivenda drop foreign key fk_comivenda_comprodu;
/* criando usuario */
create user supporte@'%' identified by 'sprt123';
/* garantido acesso de usuario */
grant all privileges on *.* to supporte@'%' with grant option;
/* 
privilégios globais aplicam-se para todos os bancos de
dados em um determinado servidor. São concedidos e revogados por
meio dos comandos a seguir, que concederão e revogarão apenas pri-
vilégios globais, respectivamente: 
*/
grant all on *.* to supporte@localhost;
revoke all on *.* ;
/*
privilégios de bancos de dados aplicam-se
a todas as tabelas em um determinado banco de dados. Os comando
para conceder e revogar apenas privilégios de banco de dados serão:
*/
grant all to application.* to supporte@localhost;
revoke all on application.*;
/*
privilégios de tabelas aplicam-se a todas as colunas
em uma determinada tabela. São concedidos ou revogados utilizando
os comandos:
*/
grant all on application.clientes;
revoke all on application.clientes;
/*
privilégios de colunas aplicam-se a uma única co-
luna em uma determinada tabela. Podem ser utilizados para os coman-
dos de seleção, inserção e atualização de determinadas colunas que de-
sejar. São concedidos utilizando os comandos:
*/
grant select(cpf),  insert(cpf), update(cpf) on application.pessoas to supporte@localhost identified by senha;
/* revogando acesso de usuario */
revoke all on *.* from supporte@'%';

/*
Nível stored routine: a rotina de alterar, criar rotina, executar e pri-
vilégios de concessão de opção aplica-se a stored procedures (procedi-
mentos e funções). Eles podem ser concedidos aos níveis globais e de
banco de dados. Também podem ser usados no nível de rotina para ro-
tinas individuais, exceto para criar uma. Se você não sabe o que é uma
store procedure, não se preocupe. No capítulo 6, você verá várias expli-
cações sobre o assunto. Esses privilégios são concedidos ou revogados
utilizando os comandos:
*/
grant routine on application.* to supporte@localhost;
grant execute on procedure application.nomeprocedure to supporte@localhost;

/*
Nível proxy user: o privilégio de proxy permite que um usuário seja
proxy de outro. O usuário externo de um outro host assume os privi-
légios de um usuário. Utilizando os comandos:
*/ 
grant PROXY on supporte@localhost to 'userexterno'@'userinterno';

/*
create table cliente(
	n_numeclient int not null auto_increment,
    c_codiclient varchar(20),
    c_cpfclient varchar(14),
    d_dataclient date,
    primary key (n_numeclient)
);
alter table cliente add column c_fornec int;
alter table gscom.cliente add column c_cidade_clien varchar(50);
alter table gscom.cliente add column e_estado_clien varchar(50); 
alter table gscom.cliente modify column c_estado_clien int;
alter table gscom.cliente drop column e_estado_clien;

desc gscom.cliente;
alter table gscom.cliente auto_increment=100;

create table fornecedor(
    c_codigo int not null auto_increment,
    n_fornec varchar(10),
    r_razao varchar(14),
    primary key (c_codigo)
);

*/


/* Fazendo testes com os constraints*/
CREATE TABLE Pai (
 ID_Pai SMALLINT PRIMARY KEY,
 Nome_Pai VARCHAR(50)
);

CREATE TABLE Filho (
 ID_Filho SMALLINT AUTO_INCREMENT PRIMARY KEY,
 Nome_Filho VARCHAR(50),
 ID_Pai SMALLINT,
 CONSTRAINT fk_id_pai FOREIGN KEY (ID_Pai)
 REFERENCES Pai(ID_Pai)
 ON DELETE CASCADE
 ON UPDATE CASCADE
);

INSERT INTO Pai VALUES (1,'João'), (2,'Mário'), (3,'Renato'), (4,'Emerson'), (5,'André');
INSERT INTO Filho (Nome_Filho, ID_Pai) VALUES ('João',1), ('Mário',1), ('Renato',3), ('Emerson',4), ('André',3);

SELECT P.ID_Pai, P.Nome_Pai, F.ID_Filho, F.Nome_Filho
FROM Filho F
INNER JOIN Pai P
ON F.ID_Pai = P.ID_Pai;

DELETE FROM Filho
WHERE Nome_Filho = 'Renato';

SELECT Nome_Pai, Nome_Filho
FROM Filho
INNER JOIN Pai
ON Filho.ID_Pai = Pai.ID_Pai;

DELETE FROM Pai
WHERE Nome_Pai = 'Renato';

SELECT Nome_Pai, Nome_Filho
FROM Filho
INNER JOIN Pai
ON Filho.ID_Pai = Pai.ID_Pai;