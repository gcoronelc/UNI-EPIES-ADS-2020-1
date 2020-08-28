use clinica;
go


select * from personal;
go


select * from dbo.paciente;
go

select idpaciente, nombre, apellido, idpersonal 
from dbo.paciente 
where nombre like 'jesu%'
and apellido like '%'
go


sp_help ingreso
go

insert into dbo.ingreso( idpersonal, idpaciente, fecha, habitacion, glosa )
values(?,?,convert(datetime,?,103),?,?)

-- dd/MM/yyyy -> 103


select i.*, convert(varchar(30),fecha, 120) fecha2 from dbo.INGRESO i;


