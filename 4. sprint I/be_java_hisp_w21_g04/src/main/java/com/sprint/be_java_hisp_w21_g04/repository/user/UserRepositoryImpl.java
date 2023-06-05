package com.sprint.be_java_hisp_w21_g04.repository.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl {

    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        this.users = this.getUsersJSON();
    }

    private List<User> getUsersJSON() {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy( PropertyNamingStrategy.SNAKE_CASE );
        try{
            File jsonFile = ResourceUtils.getFile("classpath:users.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {});

        }catch ( FileNotFoundException e ){
            System.out.println("Archivo JSON no encontrado");
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
