-- PREGUNTA 01 (3 Puntos)
/*
Se necesita saber la cantidad de pedidos que se han realizado por ciudad, 
que incluya la cantidad de artículos y el importe respectivo.

El resultado de tener las siguientes columnas:

	1.- Nombre de la ciudad
	2.- Cantidad de pedidos
	3.- Cantidad de productos
	4.- Importe correspondiente
*/

select 
	o.ShipCity, 
	count(distinct o.OrderID) pedidos,
	sum(od.Quantity) cantidad,
	sum(od.Quantity*od.UnitPrice) importe
from dbo.Orders o join dbo.[Order Details] od
on o.OrderID = od.OrderID
group by o.ShipCity
order by 1;

-- PREGUNTA 02 (4 Puntos)
/*
Se necesita saber cuál es el producto más vendido de cada categoría, se debe mostrar los empates.

Las columnas que debe mostrar el resultado es el siguiente:

	1.- Nombre de la categoría
	2.- Nombre del producto
	3.- Cantidad vendida
*/

with
v1 as (
	select p.CategoryID, p.ProductID, sum(od.Quantity) cantidad
	from dbo.Products p
	join dbo.[Order Details] od
	on p.ProductID = od.ProductID
	group by p.CategoryID, p.ProductID
),
v2 as (
	select CategoryID,  max(cantidad) cantidad
	from v1 
	group by CategoryID
),
v3 as (
	select v1.CategoryID, v1.ProductID, v1.cantidad
	from v1 join v2 
	on v1.CategoryID = v2.CategoryID and v1.cantidad = v2.cantidad
)
select  c.CategoryName, p.ProductName, v3.cantidad
from dbo.Categories c 
join dbo.Products p on c.CategoryID = p.CategoryID
join v3 on p.ProductID = v3.ProductID and p.CategoryID = v3.CategoryID
order by 1, 2;


-- PREGUNTA 03 (3 Puntos)
/**
Se necesita saber las ventas totales por producto, en cada ciudad.

El resultado debe mostrar las siguientes columnas:

	1.- Nombre de ciudad
	2.- Nombre de producto
	3.- Cantidad de productos vendidos
	4.- Importe total de las ventas por producto en cada ciudad
**/

select 
	o.ShipCity, p.ProductName,
	sum(od.Quantity) cantidad,
	sum(od.Quantity * od.UnitPrice) importe
from dbo.Orders o
join dbo.[Order Details] od on o.OrderID = od.OrderID
join dbo.Products p on od.ProductID = p.ProductID
group by o.ShipCity, p.ProductName
order by 1, 2;
go



