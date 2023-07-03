SELECT * FROM cliente WHERE firth_name LIKE "%Maria";

SELECT firth_name as Nombre, last_name as Apellido FROM cliente cl WHERE cl.firth_name LIKE "%Maria" AND cl.last_name LIKE "%Olguin";

SELECT firth_name as Nombre, last_name as Apellido FROM cliente cl 
	WHERE cl.idcliente IN (SELECT cliente_idcliente FROM cliente_has_plan chl WHERE chl.plan_idplan = 5);
    
SELECT firth_name as Nombre, last_name as Apellido FROM cliente cl
	WHERE cl.idcliente IN (SELECT cliente_idcliente FROM cliente_has_plan chl WHERE chl.plan_idplan = 2)
    ORDER BY cl.firth_name DESC;

UPDATE cliente SET firth_name = "Mario" WHERE idcliente = 2;

DELETE FROM cliente_has_plan WHERE cliente_idCliente = 2;

DELETE FROM cliente WHERE idcliente = 2;

SELECT * FROM plan;

SELECT * FROM plan WHERE description LIKE "%Cable";