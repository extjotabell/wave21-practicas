package com.example.blog.entities;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Blog {

    UUID id;
    String title;
    String name;
    String publicationDate;



}
