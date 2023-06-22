package com.bootcamp.grupo3.socialmeli.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("Sigo a un usuario")
  void followUser() throws Exception {

    var request = MockMvcRequestBuilders.post("/users/3/follow/2");
    var response = mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    Assertions.assertEquals("{\"message\":\"juancito siguió a nauhel correctamente!\"}", response.getResponse().getContentAsString(StandardCharsets.UTF_8));
  }

  @Test
  @DisplayName("Sigo a un usuario dando ids inexistentes")
  void followInvalidUsers() throws Exception {

    var request = MockMvcRequestBuilders.post("/users/9/follow/13");
    var response = mockMvc.perform(request)
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().is4xxClientError())
      .andReturn();

    Assertions.assertEquals("{\"message\":\"No se ha encontrado el usuario\"}", response.getResponse().getContentAsString());
  }

  @Test
  @DisplayName("Sigo a un usuario y dejo de seguirlo")
  void unfollowUser() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"));

    var request = MockMvcRequestBuilders.post("/users/1/unfollow/2");
    var response = mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    Assertions.assertEquals("{\"message\":\"mtato dejo de seguir a nauhel correctamente!\"}", response.getResponse().getContentAsString(StandardCharsets.UTF_8));
  }

  @Test
  @DisplayName("Obtengo la lista de seguidos sin orden")
  void listFollowedWithInvalidOrder() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"));
    mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/3"));

    var request = MockMvcRequestBuilders.get("/users/1/followed/list?order=invalidOrder");
    var response = mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    Assertions.assertEquals(
      "{\"followed\":[{\"user_id\":2,\"user_name\":\"nauhel\"},{\"user_id\":3,\"user_name\":\"juancito\"}],\"user_id\":1,\"user_name\":\"mtato\"}",
      response.getResponse().getContentAsString()
    );
  }

  @Test
  @DisplayName("Obtengo la lista de seguidos con orden ascendente")
  void listFollowedWithAscendentOrder() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"));
    mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/3"));

    var request = MockMvcRequestBuilders.get("/users/1/followed/list?order=name_asc");
    var response = mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    Assertions.assertEquals(
      "{\"followed\":[{\"user_id\":3,\"user_name\":\"juancito\"},{\"user_id\":2,\"user_name\":\"nauhel\"}],\"user_id\":1,\"user_name\":\"mtato\"}",
      response.getResponse().getContentAsString()
    );
  }

  @Test
  @DisplayName("Obtengo la lista de seguidos con orden descendente")
  void listFollowedWithDescendentOrder() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"));
    mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/3"));

    var request = MockMvcRequestBuilders.get("/users/1/followed/list?order=name_desc");
    var response = mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    Assertions.assertEquals(
      "{\"followed\":[{\"user_id\":2,\"user_name\":\"nauhel\"},{\"user_id\":3,\"user_name\":\"juancito\"}],\"user_id\":1,\"user_name\":\"mtato\"}",
      response.getResponse().getContentAsString()
    );
  }

  @Test
  @DisplayName("Obtengo la lista de seguidores")
  void listFollowers() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/users/2/follow/1"));
    mockMvc.perform(MockMvcRequestBuilders.post("/users/3/follow/1"));

    var request = MockMvcRequestBuilders.get("/users/1/followers/list");
    var response = mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    Assertions.assertEquals(
      "{\"followers\":[{\"user_id\":2,\"user_name\":\"nauhel\"},{\"user_id\":3,\"user_name\":\"juancito\"}],\"user_id\":1,\"user_name\":\"mtato\"}",
      response.getResponse().getContentAsString()
    );
  }

  @Test
  @DisplayName("Obtengo la cantidad de seguidores")
  void countFollowers() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/users/2/follow/1"));
    mockMvc.perform(MockMvcRequestBuilders.post("/users/3/follow/1"));

    var request = MockMvcRequestBuilders.get("/users/1/followers/count");

    var response = mockMvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    Assertions.assertEquals("{\"user_id\":1,\"user_name\":\"mtato\",\"followers_count\":2}", response.getResponse().getContentAsString());
  }
}
