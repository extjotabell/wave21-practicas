# Ejericio 1

Tengo una base de datos relacional que utilizo para guardar información sobre el carrito de compras. 
- Cuando alguien abandona el carrito, se inserta un registro en una tabla.
- Quiero que cuando eso pase, la API de Growth pueda enviar una notificación al usuario para que retome el carrito.
--------
Para esto creo que una posible solucion podria ser utilizando una cola de mensajes, streams, etc. De esta forma podemos suscribir al servicio de la API, para que reciba este mensaje y pueda mandar el mensaje correspondiente.
<hr>
<br>

# Ejericio 2
Tengo un KVS que utilizo para guardar mis items, a los cuales se accede habitualmente por clave, no obstante, ahora me surgió una necesidad de que en ciertos casos quiero poder buscar y agrupar por categoría
<hr>
Este problema es sencillo de solucionar utilizando una base de datos orientada a documentos. En estos documentos podemos almacenar datos basicos de los items. Como el nombre, la categoria, y por supuesto, el valor de la key (correspondiente al item) de la base de datos KV.
<br>
De esta forma, podemos filtrar primero por categoria y obtener el valor de la key, para asi traer el item completo.

<hr>
<br>

# Ejercicio 3

Tengo un KVS y quiero poder obtener todos los datos almacenados para poder hacer operaciones en bulk sobre ellos. Cómo lo puedo resolver?
<hr>

Creo que una posible solucion podria ser usar un DS (Document Search). De esta forma podemos generar un documento que contenga los datos del KVS. Activando una sincronizacion entre ambos, podemos editar los datos de una manera mucho mas masiva.
