COMENTARIOS:

1. Aunque se podría dejar todo en una misma tabla clientes, me parece que las relaciones con la tabla "Ciudad" y transitivamente
con la tabla "Provincia" queda mejor porque queda normalizado. 

a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta

La primary key para clientes es "id_cliente". Es la que va a identificar unívocamente a los registros dentro de esta tabla. 

b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.

La primary key para planes es "id_plan". Es la que va a identificar unívocamente a los registros dentro de esta tabla. 

c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.

Es una relación "muchos a muchos", cuya ruptura para ser representada en un motor de datos se ve rota en "Plan_X_Cliente". 
Esta tabla tiene una PK doble, que también es FK, que incluye a las dos PK de las tablas que lo componen (id_cliente, id_plan). 

