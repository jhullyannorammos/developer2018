/* consulta: produtos e seus modelos  */
/* ================================================= */
select fabricante, abrangencia, modelo, lancamento
       from application.fabricantes 
       join application.modelos 
       on modelos.fabricante_id = fabricantes.codigo;
         
/* consulta: produto, modelo e fabricante  */
/* ================================================= */
select produto, fabricante, modelo, valor, lancamento
       from application.fabricantes 
       join application.produtos
       join application.modelos 
       on modelos.fabricante_id = fabricantes.codigo
       and produtos.modelo_id = modelos.codigo;
/* consulta: dados das mercadorias  */
/* ================================================= */
select * from application.fabricantes 
         join application.produtos 
         join application.modelos 
         join application.mercadorias 
         on modelos.fabricante_id = fabricantes.codigo
         and produtos.modelo_id = modelos.codigo
         and mercadorias.produto_id = produtos.codigo;
/* consulta: dados das mercadorias por id  */
/* ================================================= */
select * from application.fabricantes 
         join application.produtos 
         join application.modelos 
         join application.mercadorias 
         on modelos.fabricante_id = fabricantes.codigo
         and produtos.modelo_id = modelos.codigo
         and mercadorias.produto_id = produtos.codigo
         where mercadorias.codigo = 1;
         
select fabricante, modelo
         from application.fabricantes
         join application.modelos
         on fabricantes.codigo = modelos.fabricante_id;

/* consulta: fabricantes  */
/* ================================================= */
select codigo, fabricante from application.fabricantes;


/* consulta: modelos de fabricante  */
/* ================================================= */
select modelos.codigo, fabricante, modelo, lancamento
         from application.modelos
	     join application.fabricantes
         on modelos.fabricante_id = fabricantes.codigo;

/* consulta: funcionarios de departamento  */
/* ================================================= */
select matricula, email, cargo, departamento, hierarquia, sigla 
		from application.colaboradores
         join application.departamentos 
         on colaboradores.departamento_id = departamentos.codigo;

/* consulta: fabricante: modelo:produto  */
/* ================================================= */
select fabricante, modelo, produto, valor
       from application.produtos
       join application.modelos
       join application.fabricantes
       on modelos.fabricante_id = fabricantes.codigo
       on modelos.codigo = produtos.modelo_id;
/* consulta: fabricante: modelo:produto  */
/* ================================================= */
select produtos.codigo, modelo, produto 
         from application.produtos
         join application.modelos
         on modelos.codigo = produtos.modelo_id;
/* ================================================= */
select codigo, modelo from application.modelos;

/* consulta: mercadorias by id  */
/* ================================================= */
select produtos.codigo, serialnumber, produto, modelo, fabricante
       from application.mercadorias 
       join application.produtos
       join application.modelos
       join application.fabricantes
       on produtos.codigo = mercadorias.produto_id
       and modelos.codigo = produtos.modelo_id
       and fabricantes.codigo = modelos.fabricante_id
       where produto_id = 1;
       
/* consulta: mercadorias  */
/* ================================================= */
select count(*) from application.mercadorias;
select produto, modelo, valor, fabricante /* patrimonio, produto, nome_modelo, fabricante */
       from application.mercadorias 
       join application.produtos
       join application.modelos
       join application.fabricantes
       on produtos.codigo = mercadorias.produto_id
       and modelos.codigo = produtos.modelo_id
       and fabricantes.codigo = modelos.fabricante_id;

select departamento, patrimonio, serialnumber, produto, fabricante, modelo 
       from application.fabricantes 
       join application.produtos
       join application.modelos 
       join application.mercadorias
       on modelos.fabricante_id = fabricantes.codigo
       and mercadorias.produto_id = modelos.codigo
       and produtos.modelo_id = modelos.codigo;
/* consulta: quantidade de mercadoria em estoque  */
/* ================================================= */
select * from application.estoque;
select count(*) from application.estoque where modelo = 'optiplex 790';
select count(*) from application.estoque where modelo like 'optiplex%';
select produto, fabricante, estoque.modelo, quantidade
       from application.estoque
       join application.mercadorias
       join application.produtos
       join application.modelos
       join application.fabricantes
       on estoque.codigo = mercadorias.estoque_id
       and produtos.codigo = mercadorias.produto_id
       and produtos.modelo_id = modelos.codigo
       and modelos.fabricante_id = fabricantes.codigo
       where estocada = TRUE;
select produto, fabricante, estoque.modelo, quantidade
       from application.estoque
       join application.mercadorias
       join application.produtos
       join application.modelos
       join application.fabricantes
       on estoque.codigo = mercadorias.estoque_id
       and produtos.codigo = mercadorias.produto_id
       and produtos.modelo_id = modelos.codigo
       and modelos.fabricante_id = fabricantes.codigo
       where estocada = FALSE;
/* consulta: sobre as movimentações  */
/* ================================================= */
select mercadorias.codigo, periodo, movimentacao, estocada, serialnumber, produto, fabricante, modelo
       from application.fabricantes 
       join application.modelos 
       join application.produtos
       join application.mercadorias
       join application.movimentacao 
       on mercadorias.produto_id = produtos.codigo
       and produtos.modelo_id = modelos.codigo
       and modelos.fabricante_id = fabricantes.codigo
       and movimentacao.movimentacao = 'SAIDA'
       order by movimentacao.periodo;
/* ================================================================= */
select sistema, number_key, patrimonio 
	  from application.patrimonios
      join application.licenses
      on patrimonios.codigo = licenses.patrimonio_id;
/* ================================================================= */
select serialnumber, OS, estocada
      from application.mercadorias as mrcd
      join application.licenses as lcas
      join application.patrimonios as ptmn
      join application.estoque as stck
      on stck.codigo = mrcd.estoque_id
      where ptmn.sl_id = lcas.patrimonio_id and ptmn.mercadoria_id = mrcd.patrimonio_id;
/* ================================================================= */
select mov.movimentacao, mov.periodo, 
	   md.serialnumber, md.estocada,
       fbct.fabricante, 
       prdt.produto, 
       mdls.modelo
       from application.movimentacao as mov
       join application.movimentacao_mercadorias as mm
       join application.mercadorias as md
       /*join application.estoque as stck*/
       join application.produtos as prdt
       join application.modelos as mdls
       join application.fabricantes as fbct
       on mov.codigo = mm.movimentacao_codigo and md.codigo = mm.mercadorias_codigo
       and md.produto_id = prdt.codigo
       /*and stck.codigo = md.estoque_id*/
       and prdt.modelo_id = mdls.codigo
       and mdls.fabricante_id = fbct.codigo;
/* consulta simples */
/* ================================================= */
select * from application.usuarios;
insert into application.usuarios() values();


select * from application.departamentos;
select * from application.colaboradores;
select * from application.fornecedores;
select * from application.modelos;
select * from application.estoque;
select * from application.produtos;
select * from application.mercadorias;
select * from application.patrimonios;
select * from application.licenses;
select * from application.movimentacao;  
/* ================================================ */
create schema application;
drop schema application;