package com.bootcamp.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTORequest {
    private int id;
    private String title;
    private String authorName;
    private String publicationDate;
}
