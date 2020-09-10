
select * from dbo.lector;
go

select * from dbo.estadoprestamo;
go

select * from dbo.ejemplar;
go

-- Ejemplo transaccional de un prestamo
declare
	@lector int, @fecPrestamo date, @fecDevolucion date, @estado int, @idprestamo int,
	@idobra1 int, @item1 int, @idobra2 int, @item2 int, @cont int
begin
	-- Datos del prestamo
	set @lector = 2;
	set @fecPrestamo = getdate();
	set @fecDevolucion = getDate() + 7;
	set @estado = 1;
	-- Ejemplares
	set @idobra1 = 1;
	set @item1 = 1;
	set @idobra2 = 2;
	set @item2 = 2;
	BEGIN TRY  
		-- Inicio de TX
		BEGIN TRANSACTION; -- Inicia la transacción
		-- Verificar si el lector tiene prestamos activos
		select @cont = count(1) from dbo.prestamo 
		where idlector = @lector and idestado = @estado;
		if( @cont > 0 )
			THROW 51000, 'El lector tiene un prestamo activo.', 1;  
		-- Paso 1: Registrar prestamo
		insert into dbo.prestamo(idlector,fechaprestamo,fechadevolucion,idestado,glosa)
		values(@lector,@fecPrestamo,@fecDevolucion,@estado,'Prestamo ejecutado.');
		SELECT @idprestamo = @@IDENTITY ;
		-- Paso 2: Registrar primer item
		select @cont = count(1) from dbo.ejemplar 
		where idobra = @idobra1 and item = @item1 and idestado = 1;
		if( @cont = 0 )
			THROW 51000, 'Libro-Ejemplar no esta disponible.', 1; 
		insert into dbo.detprestamo(idprestamo,idobra,item,idestado) 
		values(@idprestamo,@idobra1,@item1,@estado);
		update dbo.ejemplar set idestado = 2
		where idobra = @idobra1 and item = @item1;
		-- Paso 3: Registrar primer item
		select @cont = count(1) from dbo.ejemplar 
		where idobra = @idobra2 and item = @item2 and idestado = 1;
		if( @cont = 0 )
			THROW 51000, 'Libro-Ejemplar no esta disponible.', 1; 
		insert into dbo.detprestamo(idprestamo,idobra,item,idestado) 
		values(@idprestamo,@idobra2,@item2,@estado);
		update dbo.ejemplar set idestado = 2
		where idobra = @idobra2 and item = @item2;
		-- Fin TX
		COMMIT TRANSACTION; -- Finaliza la transacción
	END TRY  
	BEGIN CATCH  
		PRINT  
            N'The transaction is in an uncommittable state.' +  
            'Rolling back transaction.'  
		SELECT ERROR_MESSAGE() AS ErrorMessage; 
        ROLLBACK TRANSACTION; -- Cancela la transacción
	END CATCH; 
end;
go


select * from dbo.estado;
go

select * from dbo.prestamo;
select * from dbo.detprestamo;
select * from dbo.ejemplar;


