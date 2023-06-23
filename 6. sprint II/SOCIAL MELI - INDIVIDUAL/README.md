
<h1>SOCIAL MELI 🚚 📦</h>
<h3 align="justify">SOCIAL MELI lo mejor de ambos mundos</h3>

<p align="justify">
La aplicación "SocialMeli" es una plataforma innovadora que te permite seguir y dejar de seguir a compradores de forma sencilla y eficiente. 
Con esta herramienta, los compradores tienen la capacidad de publicar productos y realizar consultas sobre los usuarios que siguen o los que los siguen. 
Es una manera práctica de mantenerse actualizado sobre las preferencias de compra de otros usuarios, descubrir nuevos productos y establecer conexiones con personas afines. 
Con SocialMeli, puedes tener un control total sobre tus seguidores y seguir de cerca las publicaciones relevantes. Simplifica la experiencia de compra y amplía tu red de contactos en el ámbito del comercio electrónico.
</p>


### Tecnologías utilizadas:
<p align="left">
  <a href="https://git-scm.com/" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="Git" width="40" height="40"/>
  </a>
  <a href="https://www.java.com" target="_blank" rel="noreferrer">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="40" height="40"/>
  </a>
  <a href="https://postman.com" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="Postman" width="40" height="40"/>
  </a>
  <a href="https://spring.io/" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="Spring" width="40" height="40"/>
  </a>
  <a href="https://www.jetbrains.com/idea/" target="_blank" rel="noreferrer">
    <img src="https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg?_ga=2.36184036.55300827.1687482849-600334929.1686454916&_gl=1*3hsn7c*_ga*NjAwMzM0OTI5LjE2ODY0NTQ5MTY.*_ga_9J976DJZ68*MTY4NzQ4Mjg0OC4zLjEuMTY4NzQ4Mjk1Ni4wLjAuMA.." alt="IntelliJ IDEA" width="40" height="40"/>
  </a>
  <a href="https://github.com" target="_blank" rel="noreferrer">
    <img src="https://www.vectorlogo.zone/logos/github/github-tile.svg" alt="GitHub" width="40" height="40"/>
  </a>

</p>

---
<h2 align="justify">Sprint II - Parte Individual</h2>
<p align="justify">
El apartado individual tiene como finalidad tomar como base el proyecto desarrollado de manera grupal, 
para luego aplicar por lo menos un test de integración para lograr una cobertura de código mayor que la 
lograda con los tests unitarios.
</p>

- *Camila Andrea Molina Neculñir* 👋🏻

### **Endpoints**:    
Se agregaron todas las validaciones en la carpeta Validations dentro del archivo json de postman (Sprint 2 Postman.json)

### Test de integración hechos:
- En la carpeta integrationtest se encuentran PostIntegrationTest y UserIntegrationTest.
- PostIntegrationTest testea:

 ```
@Test
    @DisplayName("Desarrollo Individual - sellerFollowedListPost - Camino Triste")
    public void followerUserPost() throws Exception {
        ErrorDto errorDto = new ErrorDto("Los vendedores que sigues no tienen publicaciones", 400);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String ErrorExpected = writer.writeValueAsString(errorDto);
        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", 6))
                .andExpect(status().isBadRequest())
                .andDo((mvcResult) ->{
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();
        assertEquals(ErrorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }
```

- UserIntegrationTest testea:

```
@Test
    @DisplayName("Desarrollo Individual - Follow user Camino Feliz")
    void followUserPerfectCase() throws Exception {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Has seguido a JaneSmith"));
    }
```

```
@Test
    @DisplayName("Desarrollo Individual - Follow user Camino Semi Triste")
    void followUserBadCase() throws Exception {
        // Arrange
        int userId = 3;
        int userIdToFollow = 1;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Ya se están siguiendo."));
    }
```

```
@Test
    @DisplayName("Desarrollo Individual - Unfollow user Camino Feliz")
    void unfollowUserPerfectCase() throws Exception {
        // Arrange
        int userId = 4;
        int userIdToUnfollow = 3;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Has dejado de seguir a MikeJohnson"));
    }
```

### **COVERAGE**:
<img width="1512" alt="Captura de pantalla 2023-06-23 a la(s) 15 03 20" src="https://github.com/extjotabell/wave21-practicas/assets/133799616/ecb8dda4-0846-4534-b90a-eaac5df90cee">





