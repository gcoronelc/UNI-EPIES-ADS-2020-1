
USE BIBLIOTECA 
GO


-- Estados de un prestamo
-- Se aplica al prestamo y al ejemplar

insert into dbo.ESTADOPRESTAMO(idestado, estado) values(1,'Activo');
insert into dbo.ESTADOPRESTAMO(idestado, estado) values(2,'Devuelto');
insert into dbo.ESTADOPRESTAMO(idestado, estado) values(3,'Suspedido por perdida');
insert into dbo.ESTADOPRESTAMO(idestado, estado) values(4,'Suspedido por daño del libro');


-- Lectores

insert into dbo.lector(nombre,apellido,dni,fechaFinMembresia) 
values('MAYRA', 'CCAHUANA', '65782345', '20210220');

insert into dbo.lector(nombre,apellido,dni,fechaFinMembresia) 
values('MIREYA', 'SANCHEZ', '65782345', '20210220');

insert into dbo.lector(nombre,apellido,dni,fechaFinMembresia) 
values('MIRKO', 'MONTERO', '65782345', '20210220');

insert into dbo.lector(nombre,apellido,dni,fechaFinMembresia) 
values('ROBERT', 'CASAS', '65782345', '20210220');

insert into dbo.lector(nombre,apellido,dni,fechaFinMembresia) 
values('TEOFILO', 'SEGAMA', '65782345', '20210220');

GO

select * from dbo.lector;
go

SELECT @@IDENTITY;
