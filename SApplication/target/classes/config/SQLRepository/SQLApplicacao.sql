select * from applicacao.usuarios;
select * from applicacao.editoras;
select * from applicacao.autores;
select * from applicacao.livros;

select data_registro, curso, matriculas.valor, primeiro_nome, matricula
       from applicacao.matriculas
       join applicacao.cursos
       join applicacao.alunos
       on matriculas.aluno_id = alunos.codigo and matriculas.curso_id = cursos.codigo;

select titulo, subtitulo, editora, autor 
       from applicacao.livros
       join applicacao.editoras
       join applicacao.autores
       on autores.codigo = livros.autor_id and editoras.codigo = livros.editora_id;
       
select cpf, dataNascimento, matricula, primeiro_nome, logon
       from applicacao.alunos 
       join applicacao.usuarios 
       on alunos.usuario_id = usuarios.codigo;

select curso, valor, modulo
       from applicacao.cursos
       join applicacao.disciplinas
       on cursos.codigo = disciplinas.curso_id;

create database applicacao;
drop database applicacao;

create schema applicacao;
drop schema applicacao;
