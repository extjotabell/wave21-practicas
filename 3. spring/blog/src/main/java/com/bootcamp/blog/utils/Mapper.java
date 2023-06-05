package com.bootcamp.blog.utils;

import com.bootcamp.blog.dto.request.BlogDTORequest;
import com.bootcamp.blog.dto.response.BlogDTOResponse;
import com.bootcamp.blog.model.BlogEntry;

public class Mapper {
    public static BlogEntry mapFromDTORequest(BlogDTORequest blogDTO){
        return new BlogEntry(blogDTO.getId(), blogDTO.getTitle(), blogDTO.getAuthorName(), blogDTO.getPublicationDate());
    }

    public static BlogDTORequest mapFromBlogToRequest(BlogEntry blogEntry){
        return new BlogDTORequest(blogEntry.getId(), blogEntry.getTitle(), blogEntry.getAuthorName(), blogEntry.getPublicationDate());
    }

    public static BlogDTOResponse mapFromBlogToResponse(BlogEntry blogEntry){
        return new BlogDTOResponse(blogEntry.getId(), blogEntry.getTitle(), blogEntry.getAuthorName(), blogEntry.getPublicationDate());
    }


}
