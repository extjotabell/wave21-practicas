# SocialMeli-Grupo01

Este es un proyecto creado bajo el contexto del Bootcamp 21 de MercadoLibre de backend java.
Este proyecto busca asentar practicas de colaboración grupal, para el cual se definieron el uso de metodologías SCRUM para implementar una API en Spring Boot dada una documentación técnica.
Esta API permite crear publicaciones relacionados a usuarios que pueden publicar Posts y generar relaciones entre usuarios y usuarios con publicaciones(sellers).


## Tecnologias utilizadas

- Java
- Spring Api Rest
- Spring Web
- Lombock
- Postman

## Decisiones de Equipo
- Definimos un usuario genérico que engloba a los usuarios y vendedores.
- Todos los endpoint estan definidos en un unico controlador.
- Las excepciones son lanzadas por un controlador de excepciones.
- Division de tareas agrupadas por funcionalidad, se distribuyeron estas tareas en 3 sub equipos los cuales generaron una rama por cada uno y estas se mergearon al finalizar.


# Miembros del Equipo
- Bistolfi, Martín
- De la Vega, Demian
- Deniz, Luz
- Dominguez, Gaston
- Lecaros, Francisco
- Magnelli, Mercedes
- Musso, Antonella
- Safdie, Ezequiel


# Endpoints  y responsables del desarrollo

### Bistolfi, Martin / Lecaros, Francisco

- US 0001 - POST - "/users/{userId}/follow/{userIdToFollow}"
- US 0007 - GET - "/users/{userId}/unfollow/{userIdToUnfollow}"
    
### De la Vega, Demian / Magnelli, Mercedes / Musso, Antonella / Safdie, Ezequiel

- US 0002 - GET - "/users/{userId}/followers/count"
- US 0003 - GET - "/users/{userId}/followers/list"
- US 0004 - GET - "/users/{userId}/followed/list"
- US 0008 - GET - "/users/{UserID}/followed/list?order=name_asc"

### Deniz, Luz / Dominguez, Gaston

- US 0005 - POST - "/products/post"
- US 0006 - GET - "/products/followed/{user_id}/list"
- US 0009 - GET - "/products/followed/{userId}/list?order=date_asc"

# Responsables de tests unitarios

- Dominguez, Gaston - T-0001. -- Validacion: user_id y category
- Safdie, Ezequiel - T-0002 -- Validacion:notes
- Musso, Antonella - T-0003 -- Validacion: date
- De la Vega, Demian - T-0004 -- Validacion: product_id
- Deniz, Luz - T-0005 -- Validacion: product_name
- Lecaros, Francisco - T-0006 -- Validacion: type
- Magnelli, Mercedes - T-0007 -- Validacion: brand y price
- Bistolfi, Martín - T-0008 -- Validacion: color

## Agradecimientos
1. A Messi 
2. Francia
3. A los profes 