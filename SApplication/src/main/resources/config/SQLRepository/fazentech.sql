/*O banco deverá ser chamado de “fazenda-bd”*/
create database fazenda_db;

create table fazenda_db.usuarios(
    codigo smallint not null auto_increment primary key,
    logon varchar(20),
    senha varchar(20),
    perfil ENUM('ADMIN', 'SUPPORT', 'INTERNO', 'CUSTOM'),
    funcionario_id smallint,
    constraint fk_user_funcionario foreign key(funcionario_id) references colaboradores(codigo)
);

create table fazenda_db.colaboradores(
    codigo smallint not null auto_increment primary key,
    email varchar(40),
    nome varchar(40),
    cargo varchar(40),
    salario double,
    cpf varchar(14),
    telefone varchar(11),
    endereco varchar(50)
);

create table fazenda_db.vendas(
    codigo smallint not null auto_increment primary key,
    varejista_id smallint,
    produto_id smallint,
    quantidade int,
    preco double,
    realizacao date,
    precoTotal double as (quantidade * preco),
    constraint fk_varejista foreign key(varejista_id) references varejistas(codigo),
    constraint fk_produto foreign key(produto_id) references produtos(codigo)
);

create table fazenda_db.produtos(
    codigo smallint not null auto_increment primary key,
    produto varchar(20),
    categoria varchar(20),
    medida varchar(10),
    unidade int,
    preco double
);

create table fazenda_db.estoque(
    codigo smallint not null auto_increment primary key,
    produto_id smallint,
    categoria varchar(10),
    quantidade varchar(20),
    valor_estoque double,
    constraint fk_estoque_produtos foreign key(produto_id) references produtos(codigo)
);

create table fazenda_db.veiculos(
      codigo smallint not null auto_increment primary key,
      veiculo varchar(40),
      marca varchar(20),
      valor double
);

create table fazenda_db.equipamentos(
      codigo smallint not null auto_increment primary key,
      equipamento varchar(80),
      marca varchar(20),
      valor double
);

create table fazenda_db.varejistas(
      codigo smallint not null auto_increment primary key,
      nome varchar(20),
      cnpj varchar(18),
      endereco varchar(90),
      telefone varchar(13)
);

create table fazenda_db.vacas(
      codigo smallint not null auto_increment primary key,
      codd_rfid varchar(18),
      inseminacao boolean,
      especie varchar(20),
      ultimaOrdenha date,
      idade int(1)
);

create table fazenda_db.ordenha(
       codigo smallint not null auto_increment primary key,
       funcionario_id smallint,
       vaca_id smallint,
       temperaturaLeite varchar(10),
       dataOrdenha date,
       ruminacao int(3), /* Em minutos por dia */
       constraint fk_funcionario_ordenha foreign key(funcionario_id) references colaboradores(codigo),
       constraint fk_vacas_ordenha foreign key(vaca_id) references vacas(codigo)
);

create table fazenda_db.plantios(
       codigo smallint not null auto_increment primary key,
       plantio enum('ALGODAO','SOJA'),
       producao varchar(10),
       semeadura date,
       colheita date,
       terreno_id smallint,
       constraint foreign key(terreno_id) references terrenos(codigo)
);

create table fazenda_db.terrenos(
       codigo smallint not null auto_increment primary key,
       hectares int(4),
       adubagem date
);

create database application;
drop schema application;
select * from application.departamentos;
select * from application.colaboradores;
select * from application.fornecedores;
select * from application.modelos;
select * from application.clientes;