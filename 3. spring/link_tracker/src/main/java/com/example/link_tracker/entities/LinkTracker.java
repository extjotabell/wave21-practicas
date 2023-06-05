package com.example.link_tracker.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class LinkTracker {

    UUID id;
    String url;
    Boolean valid;
    String password;
    Integer visited;

    public LinkTracker(String url, String password){
        this.id = UUID.randomUUID();
        this.url = url;
        this.valid = true;
        this.password = password;
        this.visited = 0;
    }

}
