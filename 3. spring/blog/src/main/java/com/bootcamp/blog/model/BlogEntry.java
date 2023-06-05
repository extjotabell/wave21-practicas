package com.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntry {
    private int id;
    private String title;
    private String authorName;
    private String publicationDate;
}
