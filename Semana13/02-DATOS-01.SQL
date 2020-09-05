USE BIBLIOTECA 
GO

-- Tipos de obras

insert into dbo.TIPO(idtipo,tipo) values(1,'LIBRO');
insert into dbo.TIPO(idtipo,tipo) values(2,'REVISTA');
go

-- Area del conocimiento

insert into dbo.AREA(idarea,area) values(1,'MATEMATICAS');
insert into dbo.AREA(idarea,area) values(2,'INFORMATICA');
insert into dbo.AREA(idarea,area) values(3,'CIENCIAS');
go


-- Editoriales

insert into dbo.EDITORIAL(ideditorial,nombre) values(1,'Editorial 1');
insert into dbo.EDITORIAL(ideditorial,nombre) values(2,'Editorial 2');
go


-- Autores

SET IDENTITY_INSERT DBO.AUTOR ON
go

insert into dbo.AUTOR(idautor,nombre) values(1,'Gustavo Coronel');
insert into dbo.AUTOR(idautor,nombre) values(2,'Felipe Loayza');
insert into dbo.AUTOR(idautor,nombre) values(3,'Anibal Serrano');
go

SET IDENTITY_INSERT DBO.AUTOR OFF
go


-- Estado del ejemplar

insert into dbo.ESTADO(idestado,nombre) values(1,'Disponible');
insert into dbo.ESTADO(idestado,nombre) values(2,'Prestado');
insert into dbo.ESTADO(idestado,nombre) values(3,'Deteriorado');
insert into dbo.ESTADO(idestado,nombre) values(4,'Extraviado');
go


-- LIBRO DE GUSTAVO CORONEL
-- FUNDAMENTOS DE JAVA
-- TIPO: 1-LIBRO
-- AREA: 2-INFORMATICA
-- EDITORIAL: 1

SET IDENTITY_INSERT DBO.OBRA ON
go

INSERT INTO dbo.OBRA(idobra,idtipo,idarea,codigo,titulo,sumilla,anio,ideditorial)
VALUES(1,1,2,'LIB0001','FUNDAMENTOS DE JAVA','Libro chevere',2010,1);
go

SET IDENTITY_INSERT DBO.OBRA OFF
go


-- Auores del libro

insert into dbo.AUTOR_OBRA(idobra,idautor,nota) values(1,1,'Tiene experiencia.');
insert into dbo.AUTOR_OBRA(idobra,idautor,nota) values(1,2,'Profesor de la UNI.');
go



-- Ejemplares

insert into dbo.EJEMPLAR(idobra,item,idestado,glosa) values(1,1,1,'Nuevo');
insert into dbo.EJEMPLAR(idobra,item,idestado,glosa) values(1,2,1,'Nuevo');
insert into dbo.EJEMPLAR(idobra,item,idestado,glosa) values(1,3,1,'Nuevo');
insert into dbo.EJEMPLAR(idobra,item,idestado,glosa) values(1,4,1,'Nuevo');
insert into dbo.EJEMPLAR(idobra,item,idestado,glosa) values(1,5,1,'Nuevo');
go


