



SELECT        AUTOR.nombre, OBRA.codigo, OBRA.titulo, EJEMPLAR.item, ESTADO.nombre AS Expr1
FROM            AUTOR INNER JOIN
                         AUTOR_OBRA ON AUTOR.idautor = AUTOR_OBRA.idautor INNER JOIN
                         OBRA ON AUTOR_OBRA.idobra = OBRA.idobra INNER JOIN
                         EJEMPLAR ON OBRA.idobra = EJEMPLAR.idobra INNER JOIN
                         ESTADO ON EJEMPLAR.idestado = ESTADO.idestado

