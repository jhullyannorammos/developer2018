
    alter table colaboradores 
        drop 
        foreign key FK_mm4lj7vyu934hgd0gpgr8sp7k

    alter table colaboradores 
        drop 
        foreign key FK_ecoo54goaabsle9um2qgodymv

    alter table licenses 
        drop 
        foreign key FK_h8smxutsdvgr8gitnbc6fwbfl

    alter table mercadorias 
        drop 
        foreign key FK_g9vjmo9hegetouyr8oelu6vb7

    alter table mercadorias 
        drop 
        foreign key FK_btnnwh79n6ar9eemjhnm54ckj

    alter table mercadorias 
        drop 
        foreign key FK_go4jfbtrwlu8le65hwmpp4ern

    alter table modelos 
        drop 
        foreign key FK_gl8wgl4a61jakq4jh3hjmafv3

    alter table movimentacao 
        drop 
        foreign key FK_fsj3ya1o6igyf2bqftkdisjis

    alter table movimentacao_mercadorias 
        drop 
        foreign key FK_ht5a3cmi8ndv9lnt9bqn0cjw9
 
    alter table movimentacao_mercadorias 
        drop 
        foreign key FK_jl2tjuqn6xudp4oytetypg1h3

    alter table patrimonios 
        drop 
        foreign key FK_4sinyd44onkatn6191cpevu0

    alter table patrimonios 
        drop 
        foreign key FK_3h4kkre312o7ty968ya4dtbla

    alter table produtos 
        drop 
        foreign key FK_c57uc51cgsgkuynry8g2nuf74
 
    drop table if exists cidades

    drop table if exists colaboradores

    drop table if exists departamentos

drop table 'departamentos' referenced by a foreign key constraint 'FK_beql8npsmirygks0osp6cnang' on table 'mercadorias'.

    drop table if exists estoque

    drop table if exists fornecedores

    drop table if exists licenses
 
    drop table if exists mercadorias

    drop table if exists modelos

    drop table if exists movimentacao

    drop table if exists movimentacao_mercadorias

    drop table if exists patrimonios

    drop table if exists produtos

    drop table if exists usuarios

    create table cidades (
        codigo bigint not null auto_increment,
        capital bit,
        cidade varchar(20) not null,
        federacao varchar(20),
        sigla varchar(2),
        primary key (codigo)
    )
 
    create table colaboradores (
        codigo bigint not null auto_increment,
        nomecompleto varchar(255) not null,
        cargo varchar(255),
        cnh varchar(11),
        cpf varchar(14) not null,
        dataNascimento date not null,
        email varchar(30) not null,
        bloco varchar(255),
        codigo_postal varchar(255),
        cidade varchar(255),
        complemento varchar(255),
        logradouro varchar(255),
        lote varchar(255),
        numero varchar(255),
        quadra varchar(255),
        rua varchar(255),
        tipo_endereco varchar(255),
        uf varchar(255),
        matricula varchar(255),
        remuneracao double precision,
        rg varchar(14),
        ddd varchar(2),
        telefone varchar(9),
        tipo_fone varchar(255),
        departamento_id bigint,
        usuario_codigo bigint,
        primary key (codigo)
    )
 
    create table departamentos (
        codigo bigint not null auto_increment,
        departamento varchar(255),
        hierarquia varchar(255),
        localidade varchar(255),
        sigla varchar(255),
        primary key (codigo)
    )

    create table estoque (
        codigo bigint not null auto_increment,
        estoque varchar(255),
        modelo varchar(255),
        quantidade bigint,
        primary key (codigo)
    )

    create table fornecedores (
        codigo bigint not null auto_increment,
        abrangencia varchar(255),
        bloco varchar(255),
        codigo_postal varchar(255),
        cidade varchar(255),
        complemento varchar(255),
        logradouro varchar(255),
        lote varchar(255),
        numero varchar(255),
        quadra varchar(255),
        rua varchar(255),
        tipo_endereco varchar(255),
        uf varchar(255),
        fornecedor varchar(255),
        ddd varchar(2),
        telefone varchar(9),
        tipo_fone varchar(255),
        primary key (codigo)
    )

    create table licenses (
        codigo bigint not null auto_increment,
        number_key varchar(30),
        sistema varchar(255),
        patrimonio_id bigint,
        primary key (codigo)
    )

    create table mercadorias (
        codigo bigint not null auto_increment,
        Garantia datetime,
        OS varchar(255),
        armazenamento varchar(255),
        bateria varchar(255),
        bivolt bit not null,
        bluethoot varchar(255),
        camera varchar(255),
        conectividade varchar(255),
        cor varchar(255),
        grafico varchar(255),
        memoria varchar(255),
        processamento varchar(255),
        segurança varchar(255),
        som varchar(255),
        tela varchar(255),
        unidadeOtica bit not null,
        estocada bit,
        serialnumber varchar(255) not null,
        estoque_id bigint,
        patrimonio_id bigint,
        produto_id bigint,
        primary key (codigo)
    )
 
    create table modelos (
        codigo bigint not null auto_increment,
        cor varchar(255),
        dimensao varchar(255),
        peso varchar(255),
        lancamento varchar(255),
        modelo varchar(255),
        fornecedor_id bigint not null,
        primary key (codigo)
    )

    create table movimentacao (
        codigo bigint not null auto_increment,
        concluida bit,
        movimentacao varchar(255),
        dataMovimentacao datetime,
        colaborador_id bigint,
        primary key (codigo)
    )

    create table movimentacao_mercadorias (
        movimentacao_id bigint not null,
        mercadoria_id bigint not null
    )

    create table patrimonios (
        codigo bigint not null auto_increment,
        patrimonio varchar(255),
        sucateado bit,
        mercadoria_id bigint,
        sl_id bigint,
        primary key (codigo)
    )

    create table produtos (
        codigo bigint not null auto_increment,
        produto varchar(255),
        valor double precision not null,
        modelo_id bigint,
        primary key (codigo)
    )

    create table usuarios (
        codigo bigint not null auto_increment,
        logon varchar(30) not null,
        password varchar(255),
        perfil varchar(255),
        status varchar(255),
        username varchar(255),
        primary key (codigo)
    )
 
    alter table cidades 
        add constraint UK_a39enwbopuov4riwnn2io6wm unique (cidade)

    alter table colaboradores 
        add constraint UK_kcy7wh8ac1lhmwurtvfvkec8s unique (cnh)
 
    alter table colaboradores 
        add constraint UK_js76mkcfmyaqfvfq5b1a9tv2a unique (cpf)

    alter table colaboradores 
        add constraint UK_ri9jj3oi860ua516fs7t0jmfd unique (email)

    alter table colaboradores 
        add constraint UK_rr7sf7vw123rmtfcsuko1bw11 unique (matricula)

    alter table colaboradores 
        add constraint UK_8micvps1uoufr7v6x1tki84qj unique (rg)

    alter table departamentos 
        add constraint UK_mjl0kur7idqgwl2kx6c0yqttu unique (sigla)

    alter table estoque 
        add constraint UK_2vq3dcwlwq7vhgso3sn35bxpi unique (modelo)

    alter table fornecedores 
        add constraint UK_mx8fk9a906pfinmpc0f8gokrp unique (fornecedor)

    alter table licenses 
        add constraint UK_rfc3upevs7fef0uv76jai4mgp unique (number_key)

    alter table licenses 
        add constraint UK_h8smxutsdvgr8gitnbc6fwbfl unique (patrimonio_id)
 
    alter table mercadorias 
        add constraint UK_jtns5nvk80o5tbsdib89dqt77 unique (serialnumber)
 
    alter table modelos 
        add constraint UK_og0p4uud2cnfk79gm1ymcl9b3 unique (modelo)
 
    alter table patrimonios 
        add constraint UK_emi67vt14fwsvqrpyy6fbok5x unique (patrimonio)

    alter table patrimonios 
        add constraint UK_4sinyd44onkatn6191cpevu0 unique (mercadoria_id)

    alter table patrimonios 
        add constraint UK_3h4kkre312o7ty968ya4dtbla unique (sl_id)

    alter table produtos 
        add constraint UK_c57uc51cgsgkuynry8g2nuf74 unique (modelo_id)

    alter table usuarios 
        add constraint UK_hdcx3k0fxfjjfo4ywpqcx4g59 unique (logon)

    alter table colaboradores 
        add constraint FK_mm4lj7vyu934hgd0gpgr8sp7k 
        foreign key (departamento_id) 
        references departamentos (codigo)

    alter table colaboradores 
        add constraint FK_ecoo54goaabsle9um2qgodymv 
        foreign key (usuario_codigo) 
        references usuarios (codigo)

    alter table licenses 
        add constraint FK_h8smxutsdvgr8gitnbc6fwbfl 
        foreign key (patrimonio_id) 
        references patrimonios (codigo)
 
    alter table mercadorias 
        add constraint FK_g9vjmo9hegetouyr8oelu6vb7 
        foreign key (estoque_id) 
        references estoque (codigo)

    alter table mercadorias 
        add constraint FK_btnnwh79n6ar9eemjhnm54ckj 
        foreign key (patrimonio_id) 
        references patrimonios (codigo)

    alter table mercadorias 
        add constraint FK_go4jfbtrwlu8le65hwmpp4ern 
        foreign key (produto_id) 
        references produtos (codigo)
 
    alter table modelos 
        add constraint FK_gl8wgl4a61jakq4jh3hjmafv3 
        foreign key (fornecedor_id) 
        references fornecedores (codigo)

    alter table movimentacao 
        add constraint FK_fsj3ya1o6igyf2bqftkdisjis 
        foreign key (colaborador_id) 
        references colaboradores (codigo)

    alter table movimentacao_mercadorias 
        add constraint FK_ht5a3cmi8ndv9lnt9bqn0cjw9 
        foreign key (mercadoria_id) 
        references mercadorias (codigo)

    alter table movimentacao_mercadorias 
        add constraint FK_jl2tjuqn6xudp4oytetypg1h3 
        foreign key (movimentacao_id) 
        references movimentacao (codigo)

    alter table patrimonios 
        add constraint FK_4sinyd44onkatn6191cpevu0 
        foreign key (mercadoria_id) 
        references mercadorias (codigo)

    alter table patrimonios 
        add constraint FK_3h4kkre312o7ty968ya4dtbla 
        foreign key (sl_id) 
        references licenses (codigo)

    alter table produtos 
        add constraint FK_c57uc51cgsgkuynry8g2nuf74 
        foreign key (modelo_id) 
        references modelos (codigo)

    insert 
    into
        cidades
        (capital, cidade, federacao, sigla) 
    values
        (?, ?, ?, ?)

    select
        this_.codigo as codigo1_0_0_,
        this_.capital as capital2_0_0_,
        this_.cidade as cidade3_0_0_,
        this_.federacao as federaca4_0_0_,
        this_.sigla as sigla5_0_0_ 
    from
        cidades this_GoianiaGO

    insert 
    into
        cidades
        (capital, cidade, federacao, sigla) 
    values
        (?, ?, ?, ?)

    insert 
    into
        cidades
        (capital, cidade, federacao, sigla) 
    values
        (?, ?, ?, ?)

    insert into cidades(capital, cidade, federacao, sigla) values(?, ?, ?, ?);
    
    
    
    
     
    insert into fornecedores (abrangencia, bloco, codigo_postal, cidade, complemento, logradouro, lote, numero, quadra, rua, tipo_endereco, uf, fornecedor, ddd, telefone, tipo_fone) 
    values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
 
    insert into fornecedores(abrangencia, bloco, codigo_postal, cidade, complemento, logradouro, lote, numero, quadra, rua, tipo_endereco, uf, fornecedor, ddd, telefone, tipo_fone) 
    values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
 
    insert into fornecedores(abrangencia, bloco, codigo_postal, cidade, complemento, logradouro, lote, numero, quadra, rua, tipo_endereco, uf, fornecedor, ddd, telefone, tipo_fone) 
    values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
 
    insert 
    into
        fornecedores
        (abrangencia, bloco, codigo_postal, cidade, complemento, logradouro, lote, numero, quadra, rua, tipo_endereco, uf, fornecedor, ddd, telefone, tipo_fone) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
 
    insert 
    into
        fornecedores
        (abrangencia, bloco, codigo_postal, cidade, complemento, logradouro, lote, numero, quadra, rua, tipo_endereco, uf, fornecedor, ddd, telefone, tipo_fone) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        insert 
    into
        modelos
        (cor, dimensao, peso, fornecedor_id, lancamento, modelo) 
    values
        (?, ?, ?, ?, ?, ?)
        
        
        insert 
    into
        modelos
        (cor, dimensao, peso, fornecedor_id, lancamento, modelo) 
    values
        (?, ?, ?, ?, ?, ?)
