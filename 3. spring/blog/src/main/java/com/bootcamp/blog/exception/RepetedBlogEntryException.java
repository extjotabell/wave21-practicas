package com.bootcamp.blog.exception;

public class RepetedBlogEntryException  extends RuntimeException{

    public RepetedBlogEntryException(String message) {
        super(message);
    }
}
