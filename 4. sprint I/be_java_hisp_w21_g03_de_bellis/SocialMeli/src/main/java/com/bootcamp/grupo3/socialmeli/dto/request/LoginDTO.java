package com.bootcamp.grupo3.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


public record LoginDTO(@JsonProperty("user_id") int userId, String password) {
}
