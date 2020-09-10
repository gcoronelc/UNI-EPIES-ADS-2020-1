
DROP TABLE DETPRESTAMO
go



DROP TABLE PRESTAMO
go



DROP TABLE ESTADOPRESTAMO
go



DROP TABLE COMPROBANTE
go



DROP TABLE ESTADOCOMP
go



DROP TABLE TIPOPAGO
go



DROP TABLE LECTOR
go



CREATE TABLE LECTOR
( 
	idlector             integer IDENTITY ( 1,1 ) ,
	nombre               varchar(100)  NOT NULL ,
	apellido             varchar(100)  NOT NULL ,
	dni                  varchar(20)  NOT NULL ,
	fechaFinMembresia    datetime  NOT NULL ,
	CONSTRAINT XPKLECTOR PRIMARY KEY (idlector ASC)
)
go



CREATE TABLE TIPOPAGO
( 
	idtipopago           integer  NOT NULL ,
	pago                 varchar(50)  NULL ,
	valor                numeric(10,2)  NULL ,
	CONSTRAINT XPKTIPOPAGO PRIMARY KEY (idtipopago ASC)
)
go



CREATE TABLE ESTADOCOMP
( 
	idestado             integer  NOT NULL ,
	estado               varchar(30)  NOT NULL ,
	CONSTRAINT XPKESTADOCOMP PRIMARY KEY (idestado ASC)
)
go



CREATE TABLE COMPROBANTE
( 
	idcomprobante        integer IDENTITY ( 1,1 ) ,
	idlector             integer  NOT NULL ,
	idtipopago           integer  NOT NULL ,
	importe              numeric(10,2)  NOT NULL ,
	idestado             integer  NOT NULL ,
	CONSTRAINT XPKCOMPROBANTE PRIMARY KEY (idcomprobante ASC),
	CONSTRAINT R_11 FOREIGN KEY (idlector) REFERENCES LECTOR(idlector)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT FK_COMPROBANTE_TIPOPAGO FOREIGN KEY (idtipopago) REFERENCES TIPOPAGO(idtipopago)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT R_13 FOREIGN KEY (idestado) REFERENCES ESTADOCOMP(idestado)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE TABLE ESTADOPRESTAMO
( 
	idestado             integer  NOT NULL ,
	estado               varchar(30)  NOT NULL ,
	CONSTRAINT XPKESTADOPRESTAMO PRIMARY KEY (idestado ASC)
)
go



CREATE TABLE PRESTAMO
( 
	idprestamo           integer IDENTITY ( 1,1 ) ,
	idlector             integer  NOT NULL ,
	fechaprestamo        datetime  NOT NULL ,
	fechadevolucion      datetime  NOT NULL ,
	idestado             integer  NOT NULL ,
	glosa                varchar(1500)  NULL ,
	CONSTRAINT XPKPRESTAMO PRIMARY KEY (idprestamo ASC),
	CONSTRAINT R_8 FOREIGN KEY (idlector) REFERENCES LECTOR(idlector)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT R_14 FOREIGN KEY (idestado) REFERENCES ESTADOPRESTAMO(idestado)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE TABLE DETPRESTAMO
( 
	idprestamo           integer  NOT NULL ,
	idobra               integer  NOT NULL ,
	item                 integer  NOT NULL ,
	idestado             integer  NOT NULL ,
	glosa                varchar(1500)  NULL ,
	CONSTRAINT XPKDETPRESTAMO PRIMARY KEY (idprestamo ASC,idobra ASC,item ASC),
	CONSTRAINT R_9 FOREIGN KEY (idprestamo) REFERENCES PRESTAMO(idprestamo)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT R_10 FOREIGN KEY (idobra,item) REFERENCES dbo.EJEMPLAR(idobra,item)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
CONSTRAINT R_15 FOREIGN KEY (idestado) REFERENCES ESTADOPRESTAMO(idestado)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go


