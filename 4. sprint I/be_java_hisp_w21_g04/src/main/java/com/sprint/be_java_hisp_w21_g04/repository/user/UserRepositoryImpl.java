package com.sprint.be_java_hisp_w21_g04.repository.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository{

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
            System.out.println("Archivo users.json no encontrado");
            System.out.println(e.getMessage());
        }catch( JsonProcessingException err ){
            System.out.println("Error de procesamiento de JSON");
            System.out.println(err.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Integer> getFollowersById(int user_id) {
        return this.users.stream().filter(user -> user.getUser_id()==user_id).findFirst().orElse(null).getFollowers();
    }

    @Override
    public User getById(int user_id) {
        return this.users.stream().filter(user -> user.getUser_id()==user_id).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
