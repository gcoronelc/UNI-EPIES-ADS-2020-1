-- Ejemplos de Consultas
-- 05.JUN.2020
-- SELECT

use northwind;
go


-- El importe de las ventas por año

select * from dbo.Orders;
go

select * from dbo.[Order Details];
go


select * 
from dbo.Orders o
join dbo.[Order Details] od
on o.OrderID = od.OrderID;
go

select 
	year(o.orderdate) "AÑO", 
	sum(od.UnitPrice*od.Quantity)  Ventas1,
	sum(od.UnitPrice*od.Quantity*(1 - od.Discount)) ventas2
from dbo.Orders o
join dbo.[Order Details] od
on o.OrderID = od.OrderID
group by year(o.orderdate);
go


-- Cual es el producto mas vendido por año

with 
v1 as (
		select 
			year(o.orderdate) Anio, 
			od.ProductID,
			sum(od.Quantity)  Cantidad
		from dbo.Orders o
		join dbo.[Order Details] od
		on o.OrderID = od.OrderID
		group by year(o.orderdate), od.ProductID
	),
v2 as (
		select anio, max(Cantidad) Cantidad
		from v1
		group by anio
	)
select v1.Anio, v1.ProductID, p.ProductName, v1.Cantidad
from v1 join v2 
on v1.Anio = v2.Anio and v1.Cantidad = v2.Cantidad
join Products p
on v1.ProductID = p.ProductID
go


-- Consulta utilizando la base de datos EDUCA
-- Desarrollar una sentencia SELECT para obtener
-- el siguiente reporte
/*
----------------------------------------------------------------------------
CODIGO    NOMBRE                      IMPORTE      IMPORTE     IMPORTE
CURSO     CURSO       MATRICULADOS    PROYECTADO   RECAUDADO   POR COBRAR
----------------------------------------------------------------------------
###       aaaaaaa        40            20,000.00   9,568.00    

*/



