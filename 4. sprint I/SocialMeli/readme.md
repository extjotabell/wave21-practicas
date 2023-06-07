# SocialMeli - Grupo 3

Aplicaciòn tipo ecommerce que permite a los usuarios seguir a los vendedores.

## Tecnologìas

Trello para la distribuciòn de tareas

Git y github para hostear el proyecto. 

Java Spring Boot para la creaciòn de la API.

Postman para testear las diferentes firmas utilizadas.

## Configuracion

```bash
git clone git@github.com:extjotabell/wave21-practicas.git
```
Rama be_java_hisp_w21_g03

Se debe abrir el proyecto desde la carpeta 4.Sprint 1

Si no compila correctamente, realizar los siguientes pasos: Seleccionar Edit Configurations en el panel de Run/Debug Configurations Seleccionar New configuration En el text area de Run completar con "spring-boot:run" Seleccionar Apply - OK.


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
Responsable: Individual

GET /products/promo-post/count?user_id={userId}
Responsable: Individual

  

