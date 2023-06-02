package com.example.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDto {
    String id;
    String title;
    String name;
    String publicationDate;
}
