
DROP TABLE dbo.EJEMPLAR
go



DROP TABLE dbo.ESTADO
go



DROP TABLE dbo.AUTOR_OBRA
go



DROP TABLE dbo.AUTOR
go



DROP TABLE dbo.OBRA
go



DROP TABLE dbo.EDITORIAL
go



DROP TABLE dbo.AREA
go



DROP TABLE dbo.TIPO
go



CREATE TABLE dbo.TIPO
( 
	idtipo               integer  NOT NULL ,
	tipo                 varchar(50)  NOT NULL ,
	CONSTRAINT XPKTIPO PRIMARY KEY (idtipo ASC)
)
go



CREATE TABLE dbo.AREA
( 
	idarea               integer  NOT NULL ,
	area                 varchar(100)  NOT NULL ,
	CONSTRAINT XPKAREA PRIMARY KEY (idarea ASC)
)
go



CREATE TABLE dbo.EDITORIAL
( 
	ideditorial          integer  NOT NULL ,
	nombre               varchar(100)  NOT NULL ,
	CONSTRAINT XPKEDITORIAL PRIMARY KEY (ideditorial ASC)
)
go



CREATE TABLE dbo.OBRA
( 
	idobra               integer IDENTITY ( 1,1 ) ,
	idtipo               integer  NOT NULL ,
	idarea               integer  NOT NULL ,
	codigo               varchar(20)  NOT NULL ,
	titulo               varchar(200)  NOT NULL ,
	sumilla              varchar(1500)  NULL ,
	anio                 integer  NOT NULL ,
	ideditorial          integer  NOT NULL ,
	CONSTRAINT XPKOBRA PRIMARY KEY (idobra ASC),
	CONSTRAINT FK_OBRA_TIPO FOREIGN KEY (idtipo) REFERENCES dbo.TIPO(idtipo)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT FK_OBRA_AREA FOREIGN KEY (idarea) REFERENCES dbo.AREA(idarea)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT R_3 FOREIGN KEY (ideditorial) REFERENCES dbo.EDITORIAL(ideditorial)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE TABLE dbo.AUTOR
( 
	idautor              integer IDENTITY ( 1,1 ) ,
	nombre               varchar(100)  NOT NULL ,
	CONSTRAINT XPKAUTOR PRIMARY KEY (idautor ASC)
)
go



CREATE TABLE dbo.AUTOR_OBRA
( 
	idautor              integer  NOT NULL ,
	idobra               integer  NOT NULL ,
	nota                 varchar(1000)  NULL ,
	CONSTRAINT XPKAUTOR_OBRA PRIMARY KEY (idautor ASC,idobra ASC),
	CONSTRAINT FK_AUTOR_OBRA_OBRA FOREIGN KEY (idobra) REFERENCES dbo.OBRA(idobra)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT FK_AUTOR_OBRA_AUTOR FOREIGN KEY (idautor) REFERENCES dbo.AUTOR(idautor)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE TABLE dbo.ESTADO
( 
	idestado             integer  NOT NULL ,
	nombre               varchar(50)  NOT NULL ,
	CONSTRAINT XPKESTADO PRIMARY KEY (idestado ASC)
)
go



CREATE TABLE dbo.EJEMPLAR
( 
	idobra               integer  NOT NULL ,
	item                 integer  NOT NULL ,
	idestado             integer  NOT NULL ,
	glosa                varchar(1500)  NULL ,
	CONSTRAINT XPKEJEMPLAR PRIMARY KEY (idobra ASC,item ASC),
	CONSTRAINT R_6 FOREIGN KEY (idobra) REFERENCES dbo.OBRA(idobra)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT FK_EJEMPLAR_ESTADO FOREIGN KEY (idestado) REFERENCES dbo.ESTADO(idestado)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go


