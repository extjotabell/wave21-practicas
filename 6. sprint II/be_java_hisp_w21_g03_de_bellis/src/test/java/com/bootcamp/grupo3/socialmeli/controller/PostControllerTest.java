package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.ErrorDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

	@Autowired
	MockMvc mockMvc;

	ObjectWriter writer;
	ProductDTO product;
	PostDTO post;

	@BeforeEach
	void setUp() {
		this.writer = new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.writer();

		this.product = new ProductDTO(
			1,
			"ExampleProduct",
			"type",
			"brand",
			"color",
			"note"
		);

		this.post = new PostDTO(
			1,
			LocalDate.now(),
			product,
			100,
			9_000_000D
		);
	}

	@Test
	@DisplayName("Creo un posteo nuevo de manera correcta")
	void createPostOk() throws Exception {
		String postPayload = writer.writeValueAsString(post);
		String expectedMessage = "Post agregado exitosamente con id: 1";

		var request = MockMvcRequestBuilders.post("/products/post")
			.contentType(MediaType.APPLICATION_JSON)
			.content(postPayload);

		var result = mockMvc.perform(request)
			.andExpect(status().isOk())
			.andReturn();

		MessageDTO m = new ObjectMapper()
			.readValue(result.getResponse().getContentAsString(), MessageDTO.class);

		Assertions.assertEquals(expectedMessage, m.getMessage());
	}

	@Test
	@DisplayName("Creo un posteo nuevo con un usuario invalido")
	void createPostException() throws Exception {
		this.post.setUserId(10000);
		String postPayload = writer.writeValueAsString(post);

		var request = MockMvcRequestBuilders.post("/products/post")
			.contentType(MediaType.APPLICATION_JSON)
			.content(postPayload);

		var response = mockMvc.perform(request)
			.andExpect(status().is4xxClientError())
			.andReturn();

		Assertions.assertEquals(
			"{\"message\":\"No se ha encontrado el usuario\"}",
			response.getResponse().getContentAsString()
		);
	}

	@Test
	@DisplayName("Creo un posteo con datos erroneos")
	void createPostWithInvalidDTO() throws Exception {
		ProductDTO p = new ProductDTO();
		p.setProductName("$$$$");
		p.setNotes("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

		PostDTO invalidPost = new PostDTO(
				-1,
				LocalDate.now(),
				p,
				null,
				11_000_000D
		);
		String postPayload = writer.writeValueAsString(invalidPost);

		List<String> expectedMessages = List.of(
				"El id del producto no puede estar vacío.",
				"El color no puede estar vacío.",
				"La longitud no puede superar los 80 caracteres.",
				"El precio máximo por producto es de 10.000.000",
				"La categoría no puede estar vacía.",
				"La marca no puede estar vacía.",
				"El nombre no puede poseer caracteres especiales.",
				"El tipo no puede estar vacío.",
				"El id del usuario debe ser mayor a cero"
		);

		var request = MockMvcRequestBuilders.post("/products/post")
			.contentType(MediaType.APPLICATION_JSON)
			.content(postPayload);

		var result = mockMvc.perform(request)
			.andExpect(status().is4xxClientError())
			.andReturn();

		ErrorDTO error = new ObjectMapper()
			.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorDTO.class);

		Assertions.assertTrue(error.getDescription().containsAll(expectedMessages));
	}

	@Test
	@DisplayName("Sigo a un usuario y Obtengo los posteos de mis seguidos")
	void getPostsByFollowed() throws Exception {
		//Arrange. Entiendo que todo este seteo en la vida real seria un mocko a db o una db de test, donde ya tendria esto cargado
		mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"));

		var request = MockMvcRequestBuilders.get("/products/followed/1/list");

		// Act
		var response = mockMvc.perform(request)
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();

		// Assert
		UserPostListDTO posts = new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.readValue(response.getResponse().getContentAsString(), UserPostListDTO.class);
		Assertions.assertEquals(1, posts.getUserId());
		Assertions.assertEquals(0, posts.getPosts().size());
	}
}

