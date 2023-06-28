/* Traer todos los registro de la tabla Cliente */
SELECT * FROM Cliente;

/* Traer los dni de los primeros 3 registros de la tabla Cliente */
SELECT dni FROM Cliente
LIMIT 3;

/* Traer los resgistro de la tabla Cliente donde la provincia sea Buenos Aires */
SELECT * FROM Cliente
WHERE provincia = "Buenos Aires";

/* Traer nombre y apellido de la tabla Cliente ordenados por plan de forma ascendente */
SELECT nombre,apellido FROM Cliente
ORDER BY Plan_id ASC;

/* Traer el nombre y la cuidad de la tabla Cliente entre los años 1945 y 1981 */
SELECT nombre,cuidad FROM Cliente
WHERE fecha_de_nacimiento >= "1945-01-01"
AND fecha_de_nacimiento <= "1981-12-31";

/* Traer todos los registros de la tabla Plan */
SELECT * FROM Plan;

/* Traer los tipos de planes de la tabla Plan */
SELECT tipo FROM Plan;

/* Traer la velocidad de los plannes ordenados por descuento de forma descendente */
SELECT velocidad FROM Plan
ORDER BY descuento DESC;

/* Traer el id y el precio del plan con ancho de banda mayor o igual a 20Mb */
SELECT id,precio FROM Plan
WHERE velocidad >= 20;

/* Traer la suma de todos los planes */
SELECT sum(precio) FROM Plan;