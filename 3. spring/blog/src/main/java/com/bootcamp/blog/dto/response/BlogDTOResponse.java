package com.bootcamp.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTOResponse {
    private int id;
    private String title;
    private String authorName;
    private String publicationDate;
}
