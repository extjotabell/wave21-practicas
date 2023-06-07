package com.bootcamp.grupo3.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Comparable<UserDTO> {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;

    @Override
    public int compareTo(UserDTO o) {
        return this.name.compareTo(o.getName());
    }
}
