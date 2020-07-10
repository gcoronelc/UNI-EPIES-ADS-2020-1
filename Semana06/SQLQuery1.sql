
select * from dbo.CursoProgramado;


select * from dbo.alumno;


select IdAlumno, ApeAlumno, NomAlumno, DirAlumno,
TelAlumno, EmailAlumno, Clave
from dbo.alumno
where apealumno like ?
and nomalumno like ?
go

select * 
from dbo.Curso c
join dbo.CursoProgramado cp 
on c.IdCurso = cp.IdCurso
where cp.IdCiclo = '2019-12';






