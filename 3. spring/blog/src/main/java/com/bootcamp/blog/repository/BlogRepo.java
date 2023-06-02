package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Objects;

@Repository
public class BlogRepo {

    Map <Integer , BlogEntry> repoBlog;

    public BlogRepo(){
        repoBlog = new HashMap<>();
    }

    public Integer addBlog(BlogEntry blogEntry){
        if (!repoBlog.containsKey(blogEntry.getId())){
            repoBlog.put(blogEntry.getId(), blogEntry);
            return blogEntry.getId();
        }else{
            return null;
        }
    }

    public List<BlogEntry> getAllEntries(){
        return this.repoBlog.values().stream().toList();
    }

    public BlogEntry getEntryByID(int id){
        return this.repoBlog.get(id);
    }
}

