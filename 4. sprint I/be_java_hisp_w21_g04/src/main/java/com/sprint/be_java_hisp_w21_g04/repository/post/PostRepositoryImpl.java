package com.sprint.be_java_hisp_w21_g04.repository.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl {

    private List<Post> posts = new ArrayList<>();

    public PostRepositoryImpl() {
        this.posts = this.getPostsJSON();
    }

    private List<Post> getPostsJSON() {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy( PropertyNamingStrategy.SNAKE_CASE );
        try{
            File jsonFile = ResourceUtils.getFile("classpath:posts.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {});

        }catch ( FileNotFoundException e ){
            System.out.println("Archivo posts.json no encontrado");
            System.out.println(e.getMessage());
        }catch( JsonProcessingException err ){
            System.out.println("Error de procesamiento de JSON");
            System.out.println(err.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

}
