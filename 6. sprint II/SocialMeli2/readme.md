# SocialMeli - Grupo 3

Aplicación tipo ecommerce que permite a los usuarios seguir a los vendedores.

## Tecnologías

Trello para la distribución de tareas

Git y github para hostear el proyecto. 

Java Spring Boot para la creación de la API.

Postman para testear las diferentes firmas utilizadas.

## Configuración

```bash
git clone git@github.com:extjotabell/wave21-practicas.git
```
Rama be_java_hisp_w21_g03

Se debe abrir el proyecto desde la carpeta 4.Sprint 1

Si no compila correctamente, realizar los siguientes pasos:
    Seleccionar Edit Configurations en el panel de Run/Debug Configurations
    Seleccionar Add new configuration
    Seleccionar Maven
    En el text area de Run completar con "spring-boot:run"
    Seleccionar Apply - OK.

Se deja la coleccion de Postman en la carpeta resources del proyecto

## Miembros del Equipo

Fabrizzio Cámera

Gabriel Antonietti

Juan Manuel Martin Mora

Luciano Lattante

Matias Tato

Mercedes Sabaj

Nahuel De Bellis

Ornella Quarracino

## Decisiones del equipo

El diagrama de clases y el armado inicial del proyecto lo hacemos entre todos. 

En el Sprint 1 consideramos que vendedores y compradores son usuarios que comparten las mismas características, con lo cual hicimos una sola clase llamada User.

## Endpoints  y responsables del desarrollo. 

POST /users/{userId}/follow/{userIdToFollow} 
Responsables: Luciano Lattante y Ornella Quarracino

GET /users/{userId}/followers/count
Responsables: Fabrizzio Cámera y Mercedes Sabaj

GET /users/{userId}/followers/list
Responsables: Juan Manuel Martin Mora y Matías Tato

GET /users/{userId}/followed/list
Responsables: Juan Manuel Martin Mora y Matías Tato

POST /products/post
Responsables: Fabrizzio Cámera y Mercedes Sabaj

GET /products/followed/{userId}/list
Responsables: Gabriel Antonietti y Nahuel De Bellis

POST /users/{userId}/unfollow/{userIdToUnfollow}
Responsables: Luciano Lattante y Ornella Quarracino

GET /users/{UserID}/followers/list?order=name_asc
Responsables: Gabriel Antonietti y Nahuel De Bellis

GET /products/followed/{userId}/list?order=date_asc
Responsables: Gabriel Antonietti y Nahuel De Bellis

POST /products/promo-post
Responsable: Juan Manuel Martin Mora

GET /products/promo-post/count?user_id={userId}
Responsable: Juan Manuel Martin Mora

## Sprint 2 - Test

### Validaciones 

Responsabilidad: Grupal

| Dato/Parámetro | ¿Obligatorio? |                                                                Validación                                                                |                                                             Mensaje de error                                                             |
|:--------------:|:-------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|
| user_id        | Si            | Que el campo no esté vacío.<br>Mayor 0                                                                                                   | El  id no puede estar vacío.<br>El id debe ser mayor a cero                                                                              |
| date           | SI            | Que el campo no esté vacío.                                                                                                              | La fecha no puede estar vacía.                                                                                                           |
| product_id     | SI            | Que el campo no esté vacío.<br>Mayor 0                                                                                                   | La id no puede estar vacía.<br>El id debe ser mayor a cero                                                                               |
| product_name   | SI            | Que el campo no esté vacío.<br>Longitud máxima de 40 caracteres.<br>Que no posea caracteres especiales (%, &, $, etc), permite espacios. | El campo no puede estar vacío.<br>La longitud no puede superar los 40 caracteres.<br>El campo no puede poseer caracteres especiales.     |
| type           | SI            | Que el campo no esté vacío.<br>Longitud máxima de 15 caracteres.<br>Que no posea caracteres especiales (%, &, $, etc)                    | El campo no puede estar vacío.<br>La longitud no puede superar los 15 caracteres.<br>El campo no puede poseer caracteres especiales.     |
| brand          | SI            | Que el campo no esté vacío.<br>Longitud máxima de 25 caracteres.<br>Que no posea caracteres especiales (%, &, $, etc)                    | La longitud no puede superar los 25 caracteres.<br>El campo no puede estar vacío.<br>El campo no puede poseer caracteres especiales.<br> |
| color          | SI            | Que el campo no esté vacío.<br>Longitud máxima de 15 caracteres.<br>Que no posea caracteres especiales (%, &, $, etc)                    | El campo no puede estar vacío.<br>La longitud no puede superar los 15 caracteres.<br>El campo no puede poseer caracteres especiales.     |
| notes          | NO            | Longitud máxima de 80 caracteres.<br>Que no posea caracteres especiales (%, &, $, etc), permite espacios.                                | La longitud no puede superar los 80 caracteres.<br>El campo no puede poseer caracteres especiales.                                       |
| category       | SI            | Que el campo no esté vacío.                                                                                                              | El campo no puede estar vacío.                                                                                                           |
| price          | SI            | Que el campo no esté vacío<br>El precio máximo puede ser 10.000.000.                                                                     | El campo no puede estar vacío.<br>El precio máximo por producto es de 10.000.000                                                         |

### Test Unitarios

|        |                                                                        Situaciones de entrada                                                                        |                                                                                                                                             Test Realizados                                                                                                                                            |              Responsables              |
|:------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:--------------------------------------:|
| T-0001 | Verificar que el usuario a seguir exista. (US-0001)                                                                                                                  | Un usuario sigue a otro.<br>Notifica la igualdad de usuario y usuario a seguir mediante una excepción.<br>Notifica el reseguimiento mediante una excepción.<br>Notifica la no existencia del usuario mediante una excepción.<br>Notifica la no existencia del usuario a seguir mediante una excepción. | Luciano Lattante<br>Ornella Quarracino |
| T-0002 | Verificar que el usuario a dejar de seguir exista. (US-0007)                                                                                                         | Un usuario deja de seguir a otro.<br>Notifica la no existencia del usuario mediante una excepción.<br>Notifica el no seguimiento previo mediante una excepción.<br>Notifica la igualdad de usuario y usuario a dejar a seguir mediante una excepción.                                                  | Luciano Lattante<br>Ornella Quarracino |
| T-0003 | Verificar que el tipo de ordenamiento alfabético exista (US-0008)                                                                                                    | Devuelve la lista ordenada de seguidos.<br>Devuelve la lista ordenada de seguidores.<br>Notifica la no existencia del usuario al querer obtener lista de seguidos mediante una excepción.<br>Notifica la no existencia del usuario al querer obtener lista de seguidores mediante una excepción.       | Matias Tato<br>Juan Manuel Martin Mora |
| T-0004 | Verificar el correcto ordenamiento ascendente <br>y descendente por nombre. (US-0008)                                                                                | Devuelve la lista ordenada de seguidores de manera ascendente.<br>Devuelve la lista ordenada de seguidores de manera descendente.<br>Devuelve la lista ordenada de seguidos de manera ascendente.<br>Devuelve la lista ordenada de seguidos de manera descendente.                                     | Matias Tato<br>Juan Manuel Martin Mora |
| T-0005 | Verificar que el tipo de ordenamiento por fecha exista (US-0009)                                                                                                     | Devuelve la lista ordenada de posteos por fecha de manera ascendente.<br>Notifica la no existencia de usuario mediante una excepción.                                                                                                                                                                  | Gabriel Antonietti<br>Nahuel De Bellis |
| T-0006 | Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)                                                                                     | Devuelve la lista ordenada de posteos por fecha de manera descendente. <br>Devuelve la lista ordenada de posteos por precio de manera ascendente. <br>Devuelve la lista ordenada de posteos por precio de manera descendente.                                                                          | Gabriel Antonietti<br>Nahuel De Bellis |
| T-0007 | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)                                                                            | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.<br>Notifica la no existencia del usuario al querer obtener cantidad de seguidores mediante una excepción.                                                                                                    | Mercedes Sabaj<br>Fabrizzio Camera     |
| T-0008 | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006) | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.<br>(Test de Repositorio)                                                                                                                            | Gabriel Antonietti<br>Nahuel De Bellis |

### Parte Individual - Test de integracion
####Se realizan test de integraciòn sobre la capa controller de usuarios y post.  
| Test    | Endpoint                                    | Test                                                                                   |
|---------|---------------------------------------------|----------------------------------------------------------------------------------------|
| T-00010 | /users/{userId}/follow/{userIdToFollow}     | Seguir a un usuario, funcionamiento normal                                             |
| T-00010 | /users/{userId}/follow/{userIdToFollow}     | Seguir a un usuario, excepciòn por usuario invalido                                    |
| T-00010 | /users/{userId}/follow/{userIdToFollow}     | Seguir a un usuario, excepciòn por seguirse asimismo                                   |
| T-00011 | /users/{userId}/unfollow/{userIdToUnfollow} | Dejar de seguir a un usuario, funcionamiento correcto                                  |
| T-00011 | /users/{userId}/unfollow/{userIdToUnfollow} | Dejar de seguir a un usuario, excepcion por no tenerlo como seguido                    |
| T-00011 | /users/{userId}/unfollow/{userIdToUnfollow} | Dejar de seguir a un usuario, excepcion por dejar de seguirse asimismo.                |
| T-00012 | /users/{userId}/followers/count             | Obtener la cantidad de seguidores, funcionamiento correcto                             |
| T-00013 | /users/{userId}/followers/list              | Obtener la lista de seguidores, funcionamiento correcto                                |
| T-00013 | /users/{userId}/followers/list              | Obtener la lista de seguidores ordenado de manera ascendente, funcionamiento correcto  |
| T-00013 | /users/{userId}/followers/list              | Obtener la lista de seguidores ordenado de manera descendente, funcionamiento correcto |
| T-00014 | /users/{userId}/followed/list               | Obtener la lista de seguidos, funcionamiento correcto                                  |
| T-00014 | /users/{userId}/followed/list               | Obtener la lista de seguidos ordenado de manera ascendente, funcionamiento correcto    |
| T-00014 | /users/{userId}/followed/list               | Obtener la lista de seguidos ordenado de manera descendente, funcionamiento correcto   |
| T-00015 | /products/post                              | Crear un nuevo post, funcionamiento normal                                             |
| T-00015 | /products/post                              | Crear un nuevo post, funcionamiento anormal por usuario invalido                       |
| T-00015 | /products/post                              | Crear un nuevo post, funcionamiento anormal por fecha vacia                            |
| T-00015 | /products/post                              | Crear un nuevo post, funcionamiento anormal por categoria vacia                        |


#### Con todos estos test agregados, el codigo cuenta con un coverage del 92%