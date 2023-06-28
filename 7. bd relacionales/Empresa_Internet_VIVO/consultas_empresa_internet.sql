use empresa_internet;

select * from Cliente;
select * from Servicio;
select * from Cliente_Servicio;

select * from Cliente
inner join Cliente_Servicio cs
on Cliente.Id =  cs.idCliente;

select * from Cliente 
inner join Cliente_Servicio cs
on Cliente.Id =  cs.idCliente
where Nombre like "Juan";

select Nombre, Apellido, s.Velocidad , s.Precio from Cliente c
inner join Cliente_Servicio cs
on c.Id =  cs.IdCliente
inner join Servicio s
on cs.IdCliente_Servicio =  s.Id;

select c.Nombre, c.Apellido, s.Velocidad, s.Precio from Cliente c
inner join Cliente_Servicio cs on c.Id = cs.IdCliente
inner join Servicio s on cs.IdCliente_Servicio = s.Id
where s.Velocidad = (
  select MAX(velocidad)
  from Servicio
);

select * from Cliente 
order by Fecha_Nacimiento;

select SUM(s.Precio) totalFacturado from Cliente c
inner join Cliente_Servicio cs on c.Id = cs.IdCliente
inner join Servicio s on cs.IdCliente_Servicio = s.Id;

select s.id, COUNT(s.Id) from Servicio s
inner join Cliente_Servicio cs on s.id = cs.idCliente_Servicio
inner join Cliente c on cs.idCliente = c.id
group by s.Id;

select Nombre, Apellido, S.Velocidad, S.Precio from Cliente c
inner join Cliente_Servicio cs on c.Id = cs.IdCliente
inner join Servicio s on cs.IdCliente_Servicio = s.Id
where s.Velocidad > 150;