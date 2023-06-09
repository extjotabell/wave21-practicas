# SOCIAL MELI 🚚 📦

## SOCIAL MELI lo mejor de ambos mundos
La aplicación "SocialMeli" es una plataforma innovadora que te permite seguir y dejar de seguir a compradores de forma sencilla y eficiente. Con esta herramienta, los compradores tienen la capacidad de publicar productos y realizar consultas sobre los usuarios que siguen o los que los siguen. Es una manera práctica de mantenerse actualizado sobre las preferencias de compra de otros usuarios, descubrir nuevos productos y establecer conexiones con personas afines. Con SocialMeli, puedes tener un control total sobre tus seguidores y seguir de cerca las publicaciones relevantes. Simplifica la experiencia de compra y amplía tu red de contactos en el ámbito del comercio electrónico.

### Tecnologías utilizadas: 
<p align="left"> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>

### Diagrama del proyecto:
![](https://raw.githubusercontent.com/extjotabell/wave21-practicas/be_java_hisp_w21_g4/4.%20sprint%20I/Diagrama%20Sprint.png)

### Decisiones de Equipo:
- Decisión 1: Un usuario puede seguir a otro usuario, sin importar si tiene post (Usuario)
- Decisión 2: Se decide crear los atributos has_promo y discount para identificar cuando un producto está en descuento

### Miembros del Equipo:
- Carlos Alberto Oyaneder Schiaffino (Grupo 1) 🇨🇱
- Cristobal Alonso Bustamante Quito (Grupo 1) 🇨🇱
- Camila Andrea Molina Neculñir (Grupo 1) 🇨🇱
- José Juan Durón (Grupo 2) 🇲🇽
- Laura Nataly Sanabria Cepeda (Grupo 2) 🇨🇴
- Marielena Barrios Reinoso (Grupo 2) 🇨🇴
- Juan Manuel Arango (Grupo 2) 🇨🇴
- Helmer David Hernandez Ramirez (Grupo 3) 🇨🇴

### Descripción de los Endpoint:
- US 0001: Permite a un usuario seguir a un vendedor, solo si el usuario y el vendedor existen
- US 0002: Muestra el resultado de la cantidad de usuarios que siguen a un vendedor
- US 0003: Entrega el listado de todos los usuarios que siguen a un determinado vendedor
- US 0004: Entrega el listado de todos los vendedores a los cuales sigue un determinado usuario
- US 0005: Da de alta una nueva publicación recibida en el cuerpo del endpoint
- US 0006: Entrega un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas teniendo en cuenta ordenamiento por fecha (publicaciones más recientes primero)
- US 0007: Permite a un usuario dejar de seguir a un vendedor.
- US 0008: Ordena alfabéticamente en orden ascendente y descendente las US 0003 y 0004
- US 0009: Ordena por fecha ascendente y descendente la US 0006

### Endpoints y responsables del desarrollo por grupo:
- US 0001 (Grupo 1): POST /users/{userId}/follow/{userIdToFollow}
- US 0002 (Grupo 1): GET /users/{userId}/followers/count 
- US 0003 (Grupo 2): GET /users/{userId}/followers/list
- US 0004 (Grupo 2): GET /users/{userId}/followed/list
- US 0005 (Grupo 3): POST /products/post
- US 0006 (Grupo 3): GET /products/followed/{userId}/list
- US 0007 (Grupo 1): POST /users/{userId}/unfollow/{userIdToUnfollow}
- US 0008 (Grupo 2): GET /users/{UserID}/followers/list?order=name_asc
               /users/{UserID}/followers/list?order=name_desc
              /users/{UserID}/followed/list?order=name_asc
               /users/{UserID}/followed/list?order=name_desc

- US 0009 (Grupo 3): GET /products/followed/{userId}/list?order=date_asc
               /products/followed/{userId}/list?order=date_desc

### Endpoints - trabajo individual
               
- US 0010 : Llevar a cabo la publicación de un nuevo producto en promoción
  /products/promo-post
               
- US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
  /products/promo-post/count?user_id={userId}

- US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
  /products/promo-post/list?user_id={userId}

La US 0010 realiza una publicación de un nuevo producto en promoción, por lo que se utilizaron los atributos has_product y discount para validar que sea un producto en promoción, si has_product no está en true o el descuento no es mayor a cero ,no realiza el descuento.

En la US 0011 se puede obtener la cantidad de post con productos en descuento que tiene un usuario, si el usuario no tiene post, en la cantidad muestra un cero

En la US 0012 se obtiene el listado de post en rpomoción que tenga un usuario, por defecto está en orden ascendente, para descendente hay que indicar un parámetro ?order=date_desc  
               
### Mejoras futuras:
- Validar cuando un usuario no existe en las historias US 0005 y US 0006.
- Implementar DTO para el mensaje de respuesta de la historia US 0005
- Mejora de restricciones en los posts (en especial US 0005)

### Agradecimientos:
- Gracias a nuestra Scrum Master, JOY por toda la paciencia. A Carlos (Charlie) por su enseñanza en git y a todos por su trabajo!! Grande equipo! 
