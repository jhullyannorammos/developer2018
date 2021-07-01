/*O banco deverá ser chamado de “fazenda-bd”*/
create database fazenda_db;
create table fazenda_db.usuarios(
    codigo smallint not null auto_increment primary key,
    email varchar(40),
    colaborador_id smallint,
    constraint fk_user_colaborador foreign key(colaborador_id) references colaboradores(codigo)
);
/*FUNCIONÁRIOS: armazenará dados dos funcionários da fazenda (ID, nome, CPF, salários, etc.).*/
select * from fazenda_db.colaboradores;
create table fazenda_db.colaboradores(
    codigo smallint not null auto_increment primary key,
    nome varchar(40),
    cargo varchar(40),
    salario double,
    cpf varchar(14),
    endereco varchar(90),
	telefone varchar(13)
);
drop table fazenda_db.colaboradores;
/*Armazenar funcionarios na fazenda*/
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(1, "klarkent@fazentech.com.br", "Klark Kant", "Gerente", 10000.0, "754.146.550-06");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(2, "tonystark@fazentech.com.br", "Tony Stark", "Mecânico agricola", 5000.0, "921.808.020-21");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(3, "brucewayne@fazentech.com.br", "Bruce Wayne", "Produtor", 5000.0, "733.787.160-02");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(4, "natasharomanoff@fazentech.com.br", "Natasha Romanoff", "Supervisor", 4500.0, "251.849.380-87");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(5, "peterparker@fazentech.com.br", "Peter Parker", "Operador", 2000.0, "392.665.590-91");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(6, "harlekamoraes@fazentech.com.br", "Harlekina Moraes", "Consultor", 3500.0, "673.914.300-56");
/*------------------------------------------------------------------------------------*/
create table fazenda_db.plantios(
       codigo smallint not null auto_increment primary key,
       plantio enum('ALGODAO','SOJA'),
       producao varchar(10),
       semeadura date,
       colheita date,
       terreno_id smallint,
       constraint foreign key(tereno_id) references terrenos(codigo)
);
drop table fazenda_db.plantio;
/*------------------------------------------------------------------------------------*/
create table fazenda_db.terrenos(
       codigo smallint not null auto_increment primary key,
       hectares int(4),
       adubagem date
);
/*------------------------------------------------------------------------------------*/

drop table fazenda_db.telefones;
create table fazenda_db.telefones(
     codigo smallint not null auto_increment primary key,
     telefone enum('RESIDENCIAL','EMPRESARIAL','PESSOAL'),
     numero varchar(9),
     ddd varchar(2),
     funcionario_id smallint,
     constraint fk_telefone_funcionario foreign key(funcionario_id) references telefones(codigo)
);

create table fazenda_db.enderecos(
     codigo smallint not null auto_increment primary key,
     endereco enum('RESIDENCIAL','EMPRESARIAL','PESSOAL'),
     logradouro varchar(20),
     quadra varchar(10),
     numero int(4),
     cidade varchar(10),
     lote varchar(5),
     rua varchar(20),
     cep varchar(9),
     uf varchar(2),
     funcionario_id smallint,
     constraint fk_endereco_funcionario foreign key(funcionario_id) references enderecos(codigo)
);


/*-------------------------------------------------------------------------------------------*/
/*CONSULTAs AVANÇADAs*/
select produto, unidade, medida, preco, quantidade, valor_estoque from fazenda_db.produtos join fazenda_db.estoque on produtos.codigo = estoque.produto_id where produtos.codigo = 1;
select produto, unidade, medida, preco, quantidade, valor_estoque from fazenda_db.produtos join fazenda_db.estoque on produtos.codigo = estoque.produto_id order by valor_estoque;
select * from fazenda_db.produtos where categoria = 'laticínios';
select * from fazenda_db.produtos where categoria = 'bebida';
select * from fazenda_db.produtos where produto = 'ovos';
select * from fazenda_db.produtos where categoria like 'l%' or '%s';
select * from fazenda_db.produtos where produto like '%ov%';
select variance(valor_estoque) from fazenda_db.estoque;
select count(valor_estoque) from fazenda_db.estoque;
select sum(valor_estoque) from fazenda_db.estoque;
select avg(valor_estoque) from fazenda_db.estoque;
select max(valor_estoque) from fazenda_db.estoque;
select min(valor_estoque) from fazenda_db.estoque;
/*-------------------------------------------------------------------------------------------*/
/*PRODUTOS: armazenará dados de tudo o que é produzido na fazenda (ID, nome, tipo, quantidade em estoque, preço, etc.).*/
select * from fazenda_db.produtos;
create table fazenda_db.produtos(
    codigo smallint not null auto_increment primary key,
    produto varchar(20),
    categoria varchar(20),
    medida varchar(10),
    unidade int,
    preco double
);
drop table fazenda_db.produtos;
/*Estoque: contabilização dos produtos*/

select * from fazenda_db.estoque;

create table fazenda_db.estoque(
    codigo smallint not null auto_increment primary key,
    produto_id smallint,
    categoria varchar(10),
    quantidade varchar(20),
    valor_estoque double,
    constraint fk_estoque_produtos foreign key(produto_id) references produtos(codigo)
);
drop table fazenda_db.estoque;

insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(1, "Granja", 100, 900);
insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(2, "Granja", 100, 120);
insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(3, "Granja", 100, 900);
insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(4, "Bebida", 100, 600);
insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(5, "laticínios", 100, 1500);
/*inserir produtos de granja */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Ovos", "Granja", 1, 9.0, "duzia");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Ovos brancos", "Granja", 1, 12.0, "duzia");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Ovos de codorna", "Granja", 1, 9.0, "duzia");
/* inserindo produtos de padaria */
/*PRODUÇÃO DE LEITE: armazenará os dados das vacas criadas na fazenda (identificação, espécie, 
quando ocorreu a última ordenha, temperatura do leite, produtividade de cada quarto, se a vaca 
teve inseminações, a estimativa do parto, secagem esperada e até os minutos de ruminação por dia, etc.)*/
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Leite", "Bebida", 1, 6.0, "Litro");
/* inserindo produtos de padaria */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Queijo", "laticínios", 1, 15.0, "unidade");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Manteiga", "laticínios", 1, 18.0, "unidade");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Requeijão", "laticínios", 1, 25.0, "unidade");
/* inserindo produtos de acougue */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Alcatra", "Carnes bovina", 1, 19.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Costela", "Carnes bovina", 1, 30.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Picanha", "Carnes bovina", 1, 32.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Acém", "Carnes bovina", 1, 25.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Maminha", "Carnes bovina", 1, 39.0, "Kg");
/* inserindo produtos de acougue */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Pernil", "Carnes suina", 1, 40.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Bisteca", "Carnes suina", 1, 45.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Copa-lombo", "Carnes suina", 1, 36.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Coxão-duro", "Carnes suina", 1, 22.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Filé-mignon", "Carnes suina", 1, 40.0, "Kg");
/* inserindo produtos de acougue */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Asa de frango", "Carnes aviaria", 1, 12.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Peito de frango", "Carnes aviaria", 1, 11.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Coxa e sobrecoxa", "Carnes aviaria", 1, 18.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Sassami de frango", "Carnes aviaria", 1, 17.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Miúdos", "Carnes aviaria", 1, 18.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Pé", "Carnes aviaria", 1, 18.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Pescoço", "Carnes aviaria", 1, 6.0, "Kg");


/*EQUIPAMENTO: armazenará os dados dos equipamentos utilizados na fazenda para suas diversas atividades, seja para plantio ou ordenha, por exemplo (ID, nome, tipo, etc...).*/
select * from fazenda_db.veiculos;
create table fazenda_db.veiculos(
      codigo smallint not null auto_increment primary key,
      veiculo varchar(40),
      marca varchar(20),
      valor double
);
drop table fazenda_db.maquinas;
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(1, "Empilhadeira industrial", "JCB", 15000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(2, "Equipamento de compactação", "JCB", 22000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(3, "Escavadeira hidraulica", "JCB", 160000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(4, "Manipulador telescopio", "JCB", 200000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(5, "Mini carregadeira", "JCB", 25000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(6, "Mini escavadeira", "JCB", 15000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(7, "retroescavadeira", "JCB", 100000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(8, "Caminhão", "Mercedes Benz", 250000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(9, "Colheitadeira", "New Holland", 1600000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(10, "Colheitadeira", "John Deere", 2000000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(11, "Colheitadeira", "JCB", 1000000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(12, "Caminhão", "Volvo", 600000.0);
insert into fazenda_db.maquinas(codigo, maquina, marca, valor) values(13, "Trator", "Volvo", 600000.0);
/*EQUIPAMENTO: armazenará os dados dos equipamentos utilizados na fazenda para suas diversas atividades, seja para plantio ou ordenha, por exemplo (ID, nome, tipo, etc...).*/
select * from fazenda_db.equipamentos;
create table fazenda_db.equipamentos(
      codigo smallint not null auto_increment primary key,
      equipamento varchar(80),
      marca varchar(20),
      valor double
);
drop table fazenda_db.equipamentos;
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(1, "Motor industrial", "Catterpillar", 15000.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(2, "Moto-bomba", "Catterpillar", 1500.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(3, "Lavadora de Alta Pressão Ousada Plus 2200", "Wap", 600.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(4, "Motor Elétrico Nova Motores 2 Pólos Ip-21 1.5Cv Monofásico 110/220V", "Nova Motores", 650.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(5, "Compressor de Ar Schulz Fort Msw 40 Pés 425 Litros 10 Cv Trifásico 220v", "Schulz Fort MSW", 10260.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(6, "Compressor de Ar Schulz pratic Air csi 8,5 Pés 25 Litros 2 Cv Monofásico 127v", "Schulz Fort MSW", 757.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(7, "Motor Elétrico Nova 2Cv 4P Ip56 Trifásica 4V", "Nova Motores", 714.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(8, "Motor Eletrico Weg Motores Jet Pump Ir3 Ip-21 1,5cv 2 Polos Trifasico 220/380v", "Weg", 830.27);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(9, "Motor Weg Aplicações Gerais Ip-21 3cv 2 Polos Trifásico 220/380v", "Weg", 613.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(10, "Pressurizador Rowa Tango Sfl 20 Monofásico 220v - Até 4 Banheiros", "Rowa Tango", 1688.49);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(11, "Bomba Para Piscina Dancor Pf-17 1 Cv Trifasica 220v/380v", "Dancor", 786.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(12, "Autotransformador Upsai At 1500 Bivolt 110/220v", "Upsai", 123.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(13, "Gerador de Energia Mgr2400 2,9 Kva à Gasolina Manual Monofásico 110/220v", "Menegotti ", 1863.30);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(14, "Bebedouro Acqua Gelada Industrial Pre100 3 Torneiras Inox 220v 100 Litros", "EMBRACO ", 2478.90);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(15, "Compactador de Solo Csm Perc Cs70 Rental C/ Motor Honda a Gasolina", "CSM", 3370.62);



/*VAREJISTAS: armazenará informações sobre os parceiros varejistas que compram os produtos da fazenda para revenda.*/
select * from fazenda_db.varejistas;
create table fazenda_db.varejistas(
      codigo smallint not null auto_increment primary key,
      nome varchar(20),
      cnpj varchar(18),
      endereco varchar(90),
      telefone varchar(13)
);
drop table fazenda_db.varejistas;
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(1, "Casa de bolos", "50.560.242/0001-08", "71.547-021 - Rua 123 - Bairro ASC12 - São Paulo SP", "(11)1478-9652");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(2, "Açougue mimoso", "50.560.242/0001-08", "71.547-021 - Rua 123 - Bairro ASC12 - Minas Gerais MG", "(23)5689-9652");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(3, "Churrascaria gadosa", "50.560.242/0001-08", "71.547-021 - Rua 123 - Bairro ASC12 - Rio de Janeiro RJ", "(15)3647-9652");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(4, "Panificadora Bonanza", "50.560.242/0001-08", "71.547-021 - Rua 123 - Bairro ASC12 - Brasilia DF", "(61)8987-9652");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(5, "Supermercado Pratiko", "22.560.242/0001-08", "74.542-398 - Rua 47P - Bairro Universitario - Goiania GO", "(62)8484-9451");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(6, "Ultrabox", "11.590.242/0001-18", "74.148-298 - Rua K22 - Bairro JK - Gama DF", "(62)7784-1151");

/*create table vacas*/
select * from fazenda_db.vacas order by especie;


drop table fazenda_db.vacas;
create table fazenda_db.vacas(
      codigo smallint not null auto_increment primary key,
      inseminacao boolean,
      especie varchar(20),
      ultimaOrdenha date,
      idade int(1)
);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(1, "Holandesa", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(2, "Jersey", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(3, "Pardo suiço", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(4, "Zebu leiteira", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(5, "Gir", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(6, "Guzera", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(7, "Sindi", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(8, "Girolando", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(9, "Holandesa", 5, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(10, "Jersey", 4, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(11, "Pardo suiço", 6, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(12, "Zebu leiteira", 8, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(13, "Gir", 6, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(14, "Guzera", 6, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(15, "Sindi", 8, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(16, "Girolando", 8, '2020-10-01', true);

select idade, especie, inseminacao, ultimaOrdenha, dataOrdenha, temperaturaLeite 
from fazenda_db.ordenha join fazenda_db.vacas ON ordenha.vaca_id = vacas.codigo order by dataOrdenha;
select * from fazenda_db.ordenha join fazenda_db.vacas ON ordenha.vaca_id = vacas.codigo where vacas.codigo = 1;

drop table fazenda_db.ordenha;
create table fazenda_db.ordenha(
       codigo smallint not null auto_increment primary key,
       vaca_id smallint,
       temperaturaLeite varchar(10),
       dataOrdenha date,
       ruminacao int(3), /* Em minutos por dia */
       constraint fk_vacas_ordenha foreign key(vaca_id) references vacas(codigo)
);

insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-02', 480, 1);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-02', 420, 2);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 410, 3);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 440, 4);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-02', 480, 5);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-02', 320, 6);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 210, 7);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 340, 8);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-02', 380, 9);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-02', 420, 10);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 310, 11);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 440, 12);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-02', 280, 13);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-02', 320, 14);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 310, 15);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 240, 16);

insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-01', 480, 16);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-01', 420, 15);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 410, 14);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 440, 13);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-01', 480, 12);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-01', 320, 11);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 210, 10);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 340, 9);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-01', 380, 8);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-01', 420, 7);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 310, 6);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 440, 5);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-01', 280, 4);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-01', 320, 3);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 310, 2);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 240, 1);





/*O banco deverá ser chamado de “fazenda-bd”*/
create database fazenda_db;
create table fazenda_db.usuarios(
    codigo smallint not null auto_increment primary key,
    email varchar(40),
    colaborador_id smallint,
    constraint fk_user_colaborador foreign key(colaborador_id) references colaboradores(codigo)
);
/*FUNCIONÁRIOS: armazenará dados dos funcionários da fazenda (ID, nome, CPF, salários, etc.).*/
select * from fazenda_db.colaboradores;
create table fazenda_db.colaboradores(
    codigo smallint not null auto_increment primary key,
    nome varchar(40),
    cargo varchar(40),
    salario double,
    cpf varchar(14),
    endereco varchar(90),
	telefone varchar(13)
);
drop table fazenda_db.colaboradores;
/*Armazenar funcionarios na fazenda*/
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(1, "klarkent@fazentech.com.br", "Klark Kant", "Gerente", 10000.0, "754.146.550-06");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(2, "tonystark@fazentech.com.br", "Tony Stark", "Mecânico agricola", 5000.0, "921.808.020-21");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(3, "brucewayne@fazentech.com.br", "Bruce Wayne", "Produtor", 5000.0, "733.787.160-02");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(4, "natasharomanoff@fazentech.com.br", "Natasha Romanoff", "Supervisor", 4500.0, "251.849.380-87");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(5, "peterparker@fazentech.com.br", "Peter Parker", "Operador", 2000.0, "392.665.590-91");
insert into fazenda_db.colaboradores(codigo, email, nome, cargo, salario, cpf) values(6, "harlekamoraes@fazentech.com.br", "Harlekina Moraes", "Consultor", 3500.0, "673.914.300-56");
/*------------------------------------------------------------------------------------*/
create table fazenda_db.plantios(
       codigo smallint not null auto_increment primary key,
       plantio enum('ALGODAO','SOJA'),
       producao varchar(10),
       semeadura date,
       colheita date,
       terreno_id smallint,
       constraint foreign key(tereno_id) references terrenos(codigo)
);
drop table fazenda_db.plantio;
/*------------------------------------------------------------------------------------*/
create table fazenda_db.terrenos(
       codigo smallint not null auto_increment primary key,
       hectares int(4),
       adubagem date
);
/*------------------------------------------------------------------------------------*/
create table fazenda_db.produtos(
    codigo smallint not null auto_increment primary key,
    produto varchar(20),
    categoria varchar(20),
    medida varchar(10),
    unidade int,
    preco double
);
/*------------------------------------------------------------------------------------*/
create table fazenda_db.estoque(
    codigo smallint not null auto_increment primary key,
    produto_id smallint,
    categoria varchar(10),
    quantidade varchar(20),
    valor_estoque double,
    constraint fk_estoque_produtos foreign key(produto_id) references produtos(codigo)
);
/*------------------------------------------------------------------------------------*/
create table fazenda_db.veiculos(
      codigo smallint not null auto_increment primary key,
      veiculo varchar(40),
      marca varchar(20),
      valor double
);
/*------------------------------------------------------------------------------------*/
create table fazenda_db.equipamentos(
      codigo smallint not null auto_increment primary key,
      equipamento varchar(80),
      marca varchar(20),
      valor double
);
/*------------------------------------------------------------------------------------*/
create table fazenda_db.varejistas(
      codigo smallint not null auto_increment primary key,
      nome varchar(20),
      cnpj varchar(18),
      endereco varchar(90),
      telefone varchar(13)
);
/*------------------------------------------------------------------------------------*/
drop table fazenda_db.vacas;
create table fazenda_db.vacas(
      codigo smallint not null auto_increment primary key,
      rfid varchar(20),
      inseminacao boolean,
      especie varchar(20),
      ultimaOrdenha date,
      idade int(1)
);
/*------------------------------------------------------------------------------------*/
create table fazenda_db.ordenha(
       codigo smallint not null auto_increment primary key,
       vaca_id smallint,
       temperaturaLeite varchar(10),
       dataOrdenha date,
       ruminacao int(3), /* Em minutos por dia */
       constraint fk_vacas_ordenha foreign key(vaca_id) references vacas(codigo)
);
/*------------------------------------------------------------------------------------*/
create table fazenda_db.vendas(
       codigo smallint not null auto_increment primary key,
       dataVenda date,
       varejo_id smallint,
       produto_id smallint,
       constraint fk_comprador foreign key(varejo_id) references varejistas(codigo),
       constraint fk_item foreign key(produto_id) references produtos(codigo)
);

/*O banco deverá ser chamado de “fazenda-bd”*/
create database fazenda_db;
/*FUNCIONÁRIOS: armazenará dados dos funcionários da fazenda (ID, nome, CPF, salários, etc.).*/
select * from fazenda_db.funcionarios;
create table fazenda_db.funcionarios(
    codigo smallint not null auto_increment primary key,
    email varchar(40),
    nome varchar(40),
    cargo varchar(40),
    salario double,
    cpf varchar(14),
    endereco_id smallint,
    constraint fk_telefone_funcionario foreign key(telefone_id) references telefones(codigo)
);
/*Armazenar funcionarios na fazenda*/
insert into fazenda_db.funcionarios(codigo, email, nome, cargo, salario, cpf) values(1, "klarkent@fazentech.com.br", "Klark Kant", "Gerente", 10000.0, "754.146.550-06");
insert into fazenda_db.funcionarios(codigo, email, nome, cargo, salario, cpf) values(2, "tonystark@fazentech.com.br", "Tony Stark", "Mecânico agricola", 5000.0, "921.808.020-21");
insert into fazenda_db.funcionarios(codigo, email, nome, cargo, salario, cpf) values(3, "brucewayne@fazentech.com.br", "Bruce Wayne", "Produtor", 5000.0, "733.787.160-02");
insert into fazenda_db.funcionarios(codigo, email, nome, cargo, salario, cpf) values(4, "natasharomanoff@fazentech.com.br", "Natasha Romanoff", "Supervisor", 4500.0, "251.849.380-87");
insert into fazenda_db.funcionarios(codigo, email, nome, cargo, salario, cpf) values(5, "peterparker@fazentech.com.br", "Peter Parker", "Operador", 2000.0, "392.665.590-91");
insert into fazenda_db.funcionarios(codigo, email, nome, cargo, salario, cpf) values(6, "harlekamoraes@fazentech.com.br", "Harlekina Moraes", "Consultor", 3500.0, "673.914.300-56");
/*------------------------------------------------------------------------------------*/
drop table fazenda_db.telefones;
create table fazenda_db.telefones(
     codigo smallint not null auto_increment primary key,
     telefone enum('RESIDENCIAL','EMPRESARIAL','PESSOAL'),
     numero varchar(9),
     ddd varchar(2),
     funcionario_id smallint,
     constraint fk_telefone_funcionario foreign key(funcionario_id) references telefones(codigo)
);

create table fazenda_db.enderecos(
     codigo smallint not null auto_increment primary key,
     endereco enum('RESIDENCIAL','EMPRESARIAL','PESSOAL'),
     logradouro varchar(20),
     quadra varchar(10),
     numero int(4),
     cidade varchar(10),
     lote varchar(5),
     rua varchar(20),
     cep varchar(9),
     uf varchar(2),
     funcionario_id smallint,
     constraint fk_endereco_funcionario foreign key(funcionario_id) references enderecos(codigo)
);


/*-------------------------------------------------------------------------------------------*/
/*CONSULTAs AVANÇADAs*/
select produto, unidade, medida, preco, quantidade, valor_estoque from fazenda_db.produtos join fazenda_db.estoque on produtos.codigo = estoque.produto_id where produtos.codigo = 1;
select produto, unidade, medida, preco, quantidade, valor_estoque from fazenda_db.produtos join fazenda_db.estoque on produtos.codigo = estoque.produto_id order by valor_estoque;
select * from fazenda_db.produtos where categoria = 'laticínios';
select * from fazenda_db.produtos where categoria = 'bebida';
select * from fazenda_db.produtos where produto = 'ovos';
select * from fazenda_db.produtos where categoria like 'l%' or '%s';
select * from fazenda_db.produtos where produto like '%ov%';
select variance(valor_estoque) from fazenda_db.estoque;
select count(valor_estoque) from fazenda_db.estoque;
select sum(valor_estoque) from fazenda_db.estoque;
select avg(valor_estoque) from fazenda_db.estoque;
select max(valor_estoque) from fazenda_db.estoque;
select min(valor_estoque) from fazenda_db.estoque;
/*-------------------------------------------------------------------------------------------*/
/*PRODUTOS: armazenará dados de tudo o que é produzido na fazenda (ID, nome, tipo, quantidade em estoque, preço, etc.).*/
select * from fazenda_db.produtos;
create table fazenda_db.produtos(
    codigo smallint not null auto_increment primary key,
    produto varchar(20),
    categoria varchar(20),
    medida varchar(10),
    unidade int,
    preco double
);
drop table fazenda_db.produtos;
/*Estoque: contabilização dos produtos*/

select * from fazenda_db.estoque;

create table fazenda_db.estoque(
    codigo smallint not null auto_increment primary key,
    produto_id smallint,
    categoria varchar(10),
    quantidade varchar(20),
    valor_estoque double,
    constraint fk_estoque_produtos foreign key(produto_id) references produtos(codigo)
);
drop table fazenda_db.estoque;

insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(1, "Granja", 100, 900);
insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(2, "Granja", 100, 120);
insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(3, "Granja", 100, 900);
insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(4, "Bebida", 100, 600);
insert into fazenda_db.estoque(produto_id, categoria, quantidade, valor_estoque) values(5, "laticínios", 100, 1500);
/*inserir produtos de granja */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Ovos", "Granja", 1, 9.0, "duzia");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Ovos brancos", "Granja", 1, 12.0, "duzia");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Ovos de codorna", "Granja", 1, 9.0, "duzia");
/* inserindo produtos de padaria */
/*PRODUÇÃO DE LEITE: armazenará os dados das vacas criadas na fazenda (identificação, espécie, 
quando ocorreu a última ordenha, temperatura do leite, produtividade de cada quarto, se a vaca 
teve inseminações, a estimativa do parto, secagem esperada e até os minutos de ruminação por dia, etc.)*/
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Leite", "Bebida", 1, 6.0, "Litro");
/* inserindo produtos de padaria */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Queijo", "laticínios", 1, 15.0, "unidade");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Manteiga", "laticínios", 1, 18.0, "unidade");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Requeijão", "laticínios", 1, 25.0, "unidade");
/* inserindo produtos de acougue */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Alcatra", "Carnes bovina", 1, 19.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Costela", "Carnes bovina", 1, 30.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Picanha", "Carnes bovina", 1, 32.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Acém", "Carnes bovina", 1, 25.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Maminha", "Carnes bovina", 1, 39.0, "Kg");
/* inserindo produtos de acougue */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Pernil", "Carnes suina", 1, 40.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Bisteca", "Carnes suina", 1, 45.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Copa-lombo", "Carnes suina", 1, 36.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Coxão-duro", "Carnes suina", 1, 22.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Filé-mignon", "Carnes suina", 1, 40.0, "Kg");
/* inserindo produtos de acougue */
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Asa de frango", "Carnes aviaria", 1, 12.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Peito de frango", "Carnes aviaria", 1, 11.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Coxa e sobrecoxa", "Carnes aviaria", 1, 18.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Sassami de frango", "Carnes aviaria", 1, 17.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Miúdos", "Carnes aviaria", 1, 18.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Pé", "Carnes aviaria", 1, 18.0, "Kg");
insert into fazenda_db.produtos(produto, categoria, unidade, preco, medida) values("Pescoço", "Carnes aviaria", 1, 6.0, "Kg");


/*EQUIPAMENTO: armazenará os dados dos equipamentos utilizados na fazenda para suas diversas atividades, seja para plantio ou ordenha, por exemplo (ID, nome, tipo, etc...).*/
select * from fazenda_db.veiculos;
create table fazenda_db.veiculos(
      codigo smallint not null auto_increment primary key,
      veiculo varchar(40),
      marca varchar(20),
      valor double
);
drop table fazenda_db.veiculos;
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(1, "Empilhadeira industrial", "JCB", 15000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(2, "Equipamento de compactação", "JCB", 22000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(3, "Escavadeira hidraulica", "JCB", 160000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(4, "Manipulador telescopio", "JCB", 200000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(5, "Mini carregadeira", "JCB", 25000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(6, "Mini escavadeira", "JCB", 15000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(7, "retroescavadeira", "JCB", 100000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(8, "Caminhão", "Mercedes Benz", 250000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(9, "Colheitadeira", "New Holland", 1600000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(10, "Colheitadeira", "John Deere", 2000000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(11, "Colheitadeira", "JCB", 1000000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(12, "Caminhão", "Volvo", 600000.0);
insert into fazenda_db.veiculos(codigo, veiculo, marca, valor) values(13, "Trator", "Volvo", 600000.0);
/*EQUIPAMENTO: armazenará os dados dos equipamentos utilizados na fazenda para suas diversas atividades, seja para plantio ou ordenha, por exemplo (ID, nome, tipo, etc...).*/
select * from fazenda_db.equipamentos;
create table fazenda_db.equipamentos(
      codigo smallint not null auto_increment primary key,
      equipamento varchar(80),
      marca varchar(20),
      valor double
);
drop table fazenda_db.equipamentos;
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(1, "Motor industrial", "Catterpillar", 15000.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(2, "Moto-bomba", "Catterpillar", 1500.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(3, "Lavadora de Alta Pressão Ousada Plus 2200", "Wap", 600.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(4, "Motor Elétrico Nova Motores 2 Pólos Ip-21 1.5Cv Monofásico 110/220V", "Nova Motores", 650.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(5, "Compressor de Ar Schulz Fort Msw 40 Pés 425 Litros 10 Cv Trifásico 220v", "Schulz Fort MSW", 10260.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(6, "Compressor de Ar Schulz pratic Air csi 8,5 Pés 25 Litros 2 Cv Monofásico 127v", "Schulz Fort MSW", 757.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(7, "Motor Elétrico Nova 2Cv 4P Ip56 Trifásica 4V", "Nova Motores", 714.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(8, "Motor Eletrico Weg Motores Jet Pump Ir3 Ip-21 1,5cv 2 Polos Trifasico 220/380v", "Weg", 830.27);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(9, "Motor Weg Aplicações Gerais Ip-21 3cv 2 Polos Trifásico 220/380v", "Weg", 613.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(10, "Pressurizador Rowa Tango Sfl 20 Monofásico 220v - Até 4 Banheiros", "Rowa Tango", 1688.49);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(11, "Bomba Para Piscina Dancor Pf-17 1 Cv Trifasica 220v/380v", "Dancor", 786.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(12, "Autotransformador Upsai At 1500 Bivolt 110/220v", "Upsai", 123.0);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(13, "Gerador de Energia Mgr2400 2,9 Kva à Gasolina Manual Monofásico 110/220v", "Menegotti ", 1863.30);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(14, "Bebedouro Acqua Gelada Industrial Pre100 3 Torneiras Inox 220v 100 Litros", "EMBRACO ", 2478.90);
insert into fazenda_db.equipamentos(codigo, equipamento, marca, valor) values(15, "Compactador de Solo Csm Perc Cs70 Rental C/ Motor Honda a Gasolina", "CSM", 3370.62);



/*VAREJISTAS: armazenará informações sobre os parceiros varejistas que compram os produtos da fazenda para revenda.*/
select * from fazenda_db.varejistas;
create table fazenda_db.varejistas(
      codigo smallint not null auto_increment primary key,
      nome varchar(20),
      cnpj varchar(18),
      endereco varchar(90),
      telefone varchar(13)
);
drop table fazenda_db.varejistas;
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(1, "Casa de bolos", "50.560.242/0001-08", "71.547-021 - Rua 123 - Bairro ASC12 - São Paulo SP", "(11)1478-9652");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(2, "Açougue mimoso", "50.560.242/0001-08", "71.547-021 - Rua 123 - Bairro ASC12 - Minas Gerais MG", "(23)5689-9652");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(3, "Churrascaria gadosa", "50.560.242/0001-08", "71.547-021 - Rua 123 - Bairro ASC12 - Rio de Janeiro RJ", "(15)3647-9652");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(4, "Panificadora Bonanza", "50.560.242/0001-08", "71.547-021 - Rua 123 - Bairro ASC12 - Brasilia DF", "(61)8987-9652");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(5, "Supermercado Pratiko", "22.560.242/0001-08", "74.542-398 - Rua 47P - Bairro Universitario - Goiania GO", "(62)8484-9451");
insert into fazenda_db.varejistas(codigo, nome, cnpj, endereco, telefone) values(6, "Ultrabox", "11.590.242/0001-18", "74.148-298 - Rua K22 - Bairro JK - Gama DF", "(62)7784-1151");
/*create table vacas*/
select * from fazenda_db.vacas order by especie;
drop table fazenda_db.vacas;
create table fazenda_db.vacas(
      codigo smallint not null auto_increment primary key,
      inseminacao boolean,
      especie varchar(20),
      ultimaOrdenha date,
      idade int(1)
);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(1, "Holandesa", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(2, "Jersey", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(3, "Pardo suiço", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(4, "Zebu leiteira", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(5, "Gir", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(6, "Guzera", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(7, "Sindi", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(8, "Girolando", 10, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(9, "Holandesa", 5, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(10, "Jersey", 4, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(11, "Pardo suiço", 6, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(12, "Zebu leiteira", 8, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(13, "Gir", 6, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(14, "Guzera", 6, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(15, "Sindi", 8, '2020-10-01', true);
insert into fazenda_db.vacas(codigo, especie, idade, ultimaOrdenha, inseminacao) values(16, "Girolando", 8, '2020-10-01', true);

select * from fazenda_db.ordenha join fazenda_db.vacas ON ordenha.vaca_id = vacas.codigo order by dataOrdenha;
select * from fazenda_db.ordenha join fazenda_db.vacas ON ordenha.vaca_id = vacas.codigo where vacas.codigo = 1;
drop table fazenda_db.ordenha;
create table fazenda_db.ordenha(
       codigo smallint not null auto_increment primary key,
       vaca_id smallint,
       temperaturaLeite varchar(10),
       dataOrdenha date,
       ruminacao int(3), /* Em minutos por dia */
       constraint fk_vacas_ordenha foreign key(vaca_id) references vacas(codigo)
);

insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-02', 480, 1);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-02', 420, 2);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 410, 3);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 440, 4);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-02', 480, 5);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-02', 320, 6);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 210, 7);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 340, 8);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-02', 380, 9);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-02', 420, 10);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 310, 11);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 440, 12);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-02', 280, 13);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-02', 320, 14);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 310, 15);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-02', 240, 16);

insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-01', 480, 16);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-01', 420, 15);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 410, 14);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 440, 13);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-01', 480, 12);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-01', 320, 11);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 210, 10);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 340, 9);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-01', 380, 8);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-01', 420, 7);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 310, 6);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 440, 5);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("4°C", '2020-10-01', 280, 4);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("5°C", '2020-10-01', 320, 3);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 310, 2);
insert into fazenda_db.ordenha(temperaturaLeite, dataOrdenha, ruminacao, vaca_id) values("6°C", '2020-10-01', 240, 1);
