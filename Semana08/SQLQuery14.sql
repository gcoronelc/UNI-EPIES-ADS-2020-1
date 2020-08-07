

select cp.IdCursoProg, cp.IdCiclo, cp.IdCurso, cp.IdProfesor,
cp.Matriculados, cp.Vacantes, cp.PreCursoProg, cp.Horario,
cp.Activo, c.NomCurso nomCurso 
from dbo.Curso c 
join dbo.CursoProgramado cp
on c.IdCurso = cp.IdCurso 
where cp.IdCiclo = ?

