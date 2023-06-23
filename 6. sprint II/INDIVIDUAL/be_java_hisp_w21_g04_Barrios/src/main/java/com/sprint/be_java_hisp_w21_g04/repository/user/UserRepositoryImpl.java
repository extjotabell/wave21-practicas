package com.sprint.be_java_hisp_w21_g04.repository.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.IllegalDataException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    private List<User> users;

    public UserRepositoryImpl() {
        this.users = getUsersJSON();
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
    public User findUserById(int userId) {
        User user = users
                .stream()
                .filter(user1 -> user1.getUserId() == userId)
                .findFirst()
                .orElse(null);
        return user;
    }

    @Override
    public List<Integer> getFollowersById(int user_id) {
        return this.users.stream()
                         .filter(user -> user.getUserId()==user_id)
                         .findFirst().orElseThrow(()-> new IllegalDataException("Vendedor no registrado"))
                         .getFollowers();
    }

    @Override
    public List<Integer> getFollowedById(int user_id) {
        return this.users.stream()
                         .filter(user -> user.getUserId()==user_id)
                         .findFirst()
                         .orElseThrow(()-> new IllegalDataException("Usuario no registrado"))
                         .getFollowed();
    }

    @Override
    public User getById(int user_id) {
        return this.users.stream()
                         .filter(user -> user.getUserId()==user_id)
                         .findFirst()
                         .orElseThrow(()-> new IllegalDataException("Usuario no registrado"));
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
