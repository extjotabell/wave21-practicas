package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraMetrosCuadradosApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  private HouseDTO house;
  private List<RoomDTO> rooms;
  private static ObjectWriter writer;

  @BeforeAll
  static void beforeAll(){
    writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();
  }

  // a) Se pide, retornar un objeto que diga la cantidad totales de metros cuadrados de la casa.
  @BeforeEach
  void setup(){
    init();
  }

  @Test
  void calculateHouseWithoutRoom() throws Exception {
    HouseResponseDTO response = new HouseResponseDTO(house);
    response.setPrice(32012500);
    String jsonPayload = writer.writeValueAsString(house);

    String expected = writer.writeValueAsString(response);

    mockMvc.perform(post("/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload))
            .andDo(print())
            .andExpect(content().contentType("application/json"))
            .andExpect(m1 -> m1.getResponse().getContentAsString().equals(expected));

  }



  @Test
  void calculateHouseWithMultipleRoom() throws Exception {
      this.house.setRooms(this.rooms);
      HouseResponseDTO response = new HouseResponseDTO(house);

      response.setPrice(32012500);
      String jsonPayload = writer.writeValueAsString(house);

      String expected = writer.writeValueAsString(response);
      var request = post("/calculate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonPayload);

      mockMvc.perform(request)
            .andDo(print())
            .andExpect(content().contentType("application/json"))
            .andExpect(m1 -> m1.getResponse().getContentAsString().equals(expected));
  }

  //b) Indicar el valor de la casa tomando en cuenta que se toma como referencia USD 800 el metro cuadrado.
  @Test
  void calculateHousePrice() throws Exception {
    Integer squareFeet = 52500;
    Integer expectedPrice = squareFeet*800;

    this.house.setRooms(this.rooms);

    String jsonPayload = writer.writeValueAsString(this.house);

    var req = post("/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload);

    MvcResult response = mockMvc.perform(req)
            .andDo(print())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andReturn();

    HouseResponseDTO houseResponse = new ObjectMapper().readValue(
        response.getResponse().getContentAsString(),
        HouseResponseDTO.class
    );

    Assertions.assertEquals(expectedPrice, houseResponse.getPrice());
    Assertions.assertEquals(squareFeet, houseResponse.getSquareFeet());
  }

  //c) Retornar el objecto con la habitacion mas grande.
  @Test
  void calculateBiggestRoom() throws Exception {
    this.house.setRooms(this.rooms);
    HouseResponseDTO body = new HouseResponseDTO(house);

    body.setPrice(32012500);
    body.setBiggest(this.rooms.get(2));
    String jsonPayload = writer.writeValueAsString(house);

    String expectedBiggest = writer.writeValueAsString(body);
    var request = post("/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload);

    MvcResult response = mockMvc.perform(request)
            .andDo(print())
            .andExpect(content().contentType("application/json"))
            .andReturn();

    HouseResponseDTO houseResponse = new ObjectMapper().readValue(
            response.getResponse().getContentAsString(),
            HouseResponseDTO.class
    );
    String expectedBody = writer.writeValueAsString(body.getBiggest());
    String result = writer.writeValueAsString(houseResponse.getBiggest());

    Assertions.assertEquals(expectedBody, result);
  }

  private String getRoom(String name, int width, int length) {
      return "";
  }

  private void init(){
    this.house = new HouseDTO();
    house.setName("La casita de Flagus");
    house.setAddress("Calle falsa 123");

    this.rooms = new ArrayList<>();
    rooms.add(new RoomDTO("Comedor",100,100));
    rooms.add(new RoomDTO("Patio",50,50));
    rooms.add(new RoomDTO("Pieza 1", 200 , 200));
  }

}
