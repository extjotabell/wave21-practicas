# SOCIAL MELI 🚚 📦
### SOCIAL MELI lo mejor de ambos mundos
La aplicación "SocialMeli" es una plataforma innovadora que te permite seguir y dejar de seguir a compradores de forma sencilla y eficiente. Con esta herramienta, los compradores tienen la capacidad de publicar productos y realizar consultas sobre los usuarios que siguen o los que los siguen. Es una manera práctica de mantenerse actualizado sobre las preferencias de compra de otros usuarios, descubrir nuevos productos y establecer conexiones con personas afines. Con SocialMeli, puedes tener un control total sobre tus seguidores y seguir de cerca las publicaciones relevantes. Simplifica la experiencia de compra y amplía tu red de contactos en el ámbito del comercio electrónico.

### Tecnologías utilizadas:
<p align="left"> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>

### Miembros del Equipo:
- Carlos Alberto Oyaneder Schiaffino (Grupo 1) 🇨🇱
- Cristobal Alonso Bustamante Quito (Grupo 1) 🇨🇱
- Camila Andrea Molina Neculñir (Grupo 1) 🇨🇱
- José Juan Durón (Grupo 2) 🇲🇽
- Laura Nataly Sanabria Cepeda (Grupo 2) 🇨🇴
- Marielena Barrios Reinoso (Grupo 2) 🇨🇴
- Juan Manuel Arango (Grupo 3) 🇨🇴
- Helmer David Hernandez Ramirez (Grupo 3) 🇨🇴

### Diagrama del proyecto:
<img width="663" alt="image" src="https://github.com/extjotabell/wave21-practicas/assets/133796182/93c7b932-3e8c-4eae-99fd-61a31cb18610">


---


## Sprint 2:

### Decisiones de equipo:
- Se tomó como decisión de equipo permitir al usuario poder publicar un producto cuantas veces quisiera, sin considerar las validaciones de (fecha, productName, userId, etc...)

### Validaciones:
- **Tabla de información**:    
  ![img_1.png](img_1.png)
  ![img_2.png](img_2.png)

- **Endpoints**:    
  Se agregaron todas las validaciones en la carpeta Validations dentro del archivo json de postman (Sprint 2 Postman.json).


### Resumen de mejoras sprint 1:
- ✅ Validar cuando un usuario no existe en las historias US 0005 y US 0006.
- ✅ Implementar DTO para el mensaje de respuesta de la historia US 0005
- ✅ Mejora de restricciones en los posts (en especial US 0005)

### Descripción de los Tests Unitarios:
![img.png](img.png)

### Agradecimientos:
- Gracias a nuestra Scrum Master, JOY por toda la paciencia.
- Gracias Tincho por la ayuda y apoyo en la resolución de los problemas o dudas.

### Historial de commits perdidos en acción, los cuales se pueden consultar con el respectivo hash:
- Con el siguiente comando validamos los commits perdidos:
    - `git show b136e61d72b08fcf23e2da5d134121e7f7654d41`


Lo que ocurrió fue que Charlie quería realizar un SQUASH para juntar todos los commits (16) del subequipo 2 para que estos tuvieran 1 tipo de mensaje (formato). Lamentablemente esto no ocurrió como se esperaba y se perdió visibilidad (historial) de los commits del subequipo 2. A continuación se muestra el historial de commits perdidos en acción:

```
commit b136e61d72b08fcf23e2da5d134121e7f7654d41 (HEAD -> be_java_hisp_w21_g4_2, origin/be_java_hisp_w21_g4_2)
Author: laurasanabriameli <laura.sanabria@mercadolibre.com.co>
Date:   Thu Jun 22 11:38:31 2023 -0500

    Cambiando nombre de test

commit 549f52b3d8339c89baf96b83ce214260b7df8e0d
Author: laurasanabriameli <laura.sanabria@mercadolibre.com.co>
Date:   Thu Jun 22 11:33:03 2023 -0500

    Agregando test de la T0003 con la validación del assertDoesNotThrow

commit 605189a313ccda2e2f3f628672fe7f68aca75c2c
Author: laurasanabriameli <laura.sanabria@mercadolibre.com.co>
Date:   Fri Jun 16 17:25:10 2023 -0500

    Corrigiendo nombres de tests

commit e7e6dc0a3ae29bddec7d97b53edbbf2442b6188d
Author: laurasanabriameli <laura.sanabria@mercadolibre.com.co>
Date:   Fri Jun 16 17:21:22 2023 -0500

    Agregando test: T0004-Lanzando Excepcion cuando el vendedor no tiene seguidores

commit 446e7675c4ac521faf86207b68562955cc6485aa
Author: laurasanabriameli <laura.sanabria@mercadolibre.com.co>
Date:   Fri Jun 16 17:20:44 2023 -0500

    Agregando test: T0004-Lanzando Excepcion cuando el vendedor no tiene seguidos

commit d7924a9f16cca9fd96263181cc111a62ce2316ca
Author: laurasanabriameli <laura.sanabria@mercadolibre.com.co>
Date:   Fri Jun 16 17:19:59 2023 -0500

    Agregando test: T0004-Lanzando Excepcion cuando el usuario no existe en seguidores

commit fd7ae372207ca8df33b968cae26b2e07ab22dc09
Author: laurasanabriameli <laura.sanabria@mercadolibre.com.co>
Date:   Fri Jun 16 17:19:02 2023 -0500

    Agregando test: T0004-Lanzando Excepcion cuando el usuario no existe en seguidos

commit 72ad0175e45da1e193d486f20eaf21fe918d208c
Author: laurasanabriameli <laura.sanabria@mercadolibre.com.co>
Date:   Fri Jun 16 17:17:57 2023 -0500

    Agregando test: T0004-Obteniendo lista de seguidores de un usuario por id con orden descendente

commit 6774333ac8efb5e33511c58808394024ef818a60
Author: marielebarri <marielena.barrios@mercadolibre.com.co>
Date:   Fri Jun 16 17:11:43 2023 -0500

    Agregando test: T0004-Obteniendo lista de seguidores de un usuario por id con orden ascendente

commit bcd2bd95d3333374df39a6977b55397cede45927
Author: marielebarri <marielena.barrios@mercadolibre.com.co>
Date:   Fri Jun 16 17:09:49 2023 -0500

    Agregando test: T0004-Obteniendo lista de seguidos de un usuario por id con orden descendente

commit b6821edb5be569fd8f0afb15f2b5d2b9fe813a02
Author: marielebarri <marielena.barrios@mercadolibre.com.co>
Date:   Fri Jun 16 17:08:31 2023 -0500

    Agregando test: T0004-Obteniendo lista de seguidos de un usuario por id con orden ascendente

commit a8b53f15371a5ca99d823d99865ae91159b09b83
Author: marielebarri <marielena.barrios@mercadolibre.com.co>
Date:   Fri Jun 16 17:07:21 2023 -0500

    Agregando test: T0003-Obteniendo lista de seguidores de un usuario por id con orden erroneo

commit f11e2859d60e616ab852a587cb0f49cf70be2094
Author: marielebarri <marielena.barrios@mercadolibre.com.co>
Date:   Fri Jun 16 17:06:25 2023 -0500

    Agregando test: T0003-Obteniendo lista de seguidos de un usuario por id con orden erroneo

commit bad0a25b2edcd1e2ebbfe2c25f56679fd36cf47a
Author: Jojoseju <jose.duronaraujo@mercadolibre.com.mx>
Date:   Fri Jun 16 16:00:38 2023 -0600

    Agregando test: T0003-Obteniendo lista de seguidores de un usuario por id con orden correcto

commit 74aceec19542e72531dd403f4066e84491e7257a
Author: Jojoseju <jose.duronaraujo@mercadolibre.com.mx>
Date:   Fri Jun 16 16:00:11 2023 -0600

    Agregando test: T0003-Obteniendo lista de seguidos de un usuario por id con orden correcto

commit f0c6c29ecf68c57e4b85c4badcf1f26501bf92b7
Author: Jojoseju <jose.duronaraujo@mercadolibre.com.mx>
Date:   Fri Jun 16 15:58:20 2023 -0600

    Agregando etiqueta EqualsAndHashCode en los DTO para poder realizar las comparaciones en los assertEquals
```

## Sprint 1:

### Decisiones de Equipo:
- Decisión 1: Un usuario puede seguir a otro usuario, sin importar si tiene post (Usuario)
- Decisión 2: Se decide crear los atributos has_promo y discount para identificar cuando un producto está en descuento

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
- ``US 0001`` (Grupo 1): ``POST``
    - /users/{userId}/follow/{userIdToFollow}

- ``US 0002`` (Grupo 1): ``GET``
    - /users/{userId}/followers/count

- ``US 0003`` (Grupo 2): ``GET``

    - /users/{userId}/followers/list

- ``US 0004`` (Grupo 2): ``GET``

    - /users/{userId}/followed/list

- ``US 0005`` (Grupo 3): ``POST``

    - /products/post

- ``US 0006`` (Grupo 3): ``GET``

    - /products/followed/{userId}/list

- ``US 0007`` (Grupo 1): ``POST``

    - /users/{userId}/unfollow/{userIdToUnfollow}

- ``US 0008`` (Grupo 2): ``GET``
    - /users/{UserID}/followers/list?order=name_asc
    - /users/{UserID}/followers/list?order=name_desc
    - /users/{UserID}/followed/list?order=name_asc
    - /users/{UserID}/followed/list?order=name_desc

- ``US 0009`` (Grupo 3): ``GET``
    - /products/followed/{userId}/list?order=date_asc
    - /products/followed/{userId}/list?order=date_desc


### Mejoras futuras:
- [ ] Validar cuando un usuario no existe en las historias US 0005 y US 0006.
- [ ] Implementar DTO para el mensaje de respuesta de la historia US 0005
- [ ] Mejora de restricciones en los posts (en especial US 0005)

## Desarrollo individual

Además de los tests existentes, se ha realizado desarrollo adicional para
mejorar la cobertura y calidad de pruebas. A continuación, se detalla el desarrollo
adicional realizado:

### Test de integración:
Se han realizado test de inetgración para estos controllers:
- PostController: para lograr el porcentaje ovjetivo de cobertura, implementé
  un test a cada metodo del controller, además, tuve en cuenta cada uno de los
  posibles errores o excepciones que podian surgir. En algunos casos utilicé la clase
  ObjectWriter para poder convertir a String y validar algunos DTO de errores, no lo
  hice en todos los metodos ya que no era necesario y sería bastante repetitivo.
- UserController: basicamente hice la misma práctica que en el anterior, solo que en
  este caso tuve mas excepciones por validar.

### Agradecimientos:
- Gracias a nuestra Scrum Master, JOY por toda la paciencia.
- A Carlos (Charlie) por su enseñanza en git y a todos por su trabajo!!
- ❤️ Grande equipo!
