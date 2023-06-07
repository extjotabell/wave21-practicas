# Social MeLi Sprint I
## Descripción
En este proyecto se habilita la posibilidad de seguir y dejar de seguir 
vendedores, siendo un vendedor aquel usuario que cuente con posts. Además,
se permite listar mis seguidores y seguidos permitiendo ordenarlos por nombre,
así como tambien ver la cantidad de seguidores de un usuario. 

En cuanto a las publicaciones o posts se permite la creación y consulta de las 
mismas. A la hora de consultarlas se ve la lista desde la más reciente a la más 
antigua y se permite alterar el nombre incorporarndo un parametro order, asimismo,
el listado de posts contempla mostrar posts referentes a las últimas dos semanas.

## Tecnologías utilizadas
* IntelliJ - Code with Me
* JAVA 17
* SPRING BOOT 3.1.0
* GIT
* TRELLO
* SLACK
* MAVEN
* POSTMAN
* DRAW.IO

## Decisiones de Equipo
* Se realizó un diagrama para planificar como se iba a desarrollar la API.
* Se separaron las tareas del equipo utilizando Trello.
* Se decidió separar en dos grupos, el primer grupo se encargó de tomar las tareas relacionadas
a "users" y el segundo grupo de tomar tareas relacionadas a "posts".
* Se utilizó "Code With Me" para poder trabajar en conjunto.
* Se decidió usar camel case para el desarrollo total del proyecto.
* Se decidió utilizar Hash Map dentro de User para facilitar las busquedas y 
set para guardar los ids en Followers y Following para evitar repetidos.
* Se utilizaron constantes para definir los distintos tipos de ordenamientos permitidos.


## Miembros del Equipo
* Martin Marquez - Scrum Master
* Yanina Belen Faretta - Developer
* Gonzalo Marquez - Developer
* Gaston Leonel Barro - Developer
* Jose Luis Gonzalez Portillo - Developer
* Flavio Agustín Rodríguez - Developer
* Javier Rydel - Developer
* Leandro Xavier Marcelo Supanta - Developer
* Adrián Rodríguez - Developer

## Endpoints  y responsables del desarrollo

### Metodos POST:

Follow & UnFollow

http://localhost:8080/users/{userId}/follow/{userIdToFollow}
http://localhost:8080/users/{userId}/unfollow/{userIdToUnfollow}

Products

http://localhost:8080/products/post

### Metodos GET:

Followers & Following

http://localhost:8080/users/{userId}/followed/list?order=name_asc
http://localhost:8080/users/{userId}/followers/list?order=name_asc
http://localhost:8080/users/{userId}/followers/count

Products

http://localhost:8080/products/followed/{userId}/list?order=date_asc

## Distribución de tareas del equipo
Para visualizar los responsables de cada tarea, adjuntamos la plataforma utilizada para tener un seguimiento de las tareas y responsables de las mismas.

https://trello.com/b/e7TQCB93/sprint-1

## Individual
### Promos
#### Metodos GET:
http://localhost:8080/products/promo-post/count?user_id=2
#### Metodos POST:
http://localhost:8080/products/promo-post

### Metodos DELETE:
Delete post 

http://localhost:8080/products/post/{postId}/user/{userId}
#### Documentacion: 
Se le debe enviar un id de post que es un número 
entero y un id de usuario que también es un número entero. 
No requiere body. 
* Si se logra eliminar el post se retorna un 200.
* Si no se le envia un id incorrecto retorna 400 y un Json con error_message y status.

Por ejemplo: 
```
{
    "error_message": "El usuario no es un vendedor",
    "status": "BAD_REQUEST"
}
```