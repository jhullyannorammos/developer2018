create schema usuarios;

/* consultando usuarios do mysql */
select User, Host from mysql.user;

/*criando usuario */
create user administrador@localhost identified by 'jh76dfv34';
create user usuario@localhost identified by 'ff798sdf';

set password for 'usuario'@'localhost' = password('ff798sdf');
SET PASSWORD FOR 'usuario'@'host' = PASSWORD('1234');

drop user usuario@localhost;
drop user usuario@host;

show grants for administrador@localhost;
show grants for jhullyannoorammos;
show grants for usuario@localhost;
show grants for root@localhost;

grant select on *.* to jhullyannoorammos;
grant all on applicacao.* to jhullyannoorammos@localhost;
grant usage on *.* to administrador@localhost;

grant select on application.* to usuario@localhost;
grant select on application.clientes to usuario@localhost;
grant select(primeiro_nome, cpf) on application.clientes to usuario@localhost;
grant update(segundo_nome, cnh) on application.clientes to usuario@localhost;

revoke delete on application.clientes from usuario@localhost;
revoke select(primeiro_nome, cpf) on application.clientes from usuario@localhost;
revoke update(segundo_nome, cnh) on application.clientes from usuario@localhost;




