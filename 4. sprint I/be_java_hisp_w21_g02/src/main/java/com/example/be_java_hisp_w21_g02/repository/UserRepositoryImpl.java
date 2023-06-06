package com.example.be_java_hisp_w21_g02.repository;

import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    private HashMap<Integer, User> dataUser = new HashMap<>();

    public UserRepositoryImpl(List<User> dataUser) {
        loadInitialData();
        // comentario para probar PRS
    }

    public User getUser(int userIdToFollow){
        return  dataUser.get(userIdToFollow);
    }

    public void persistFollows(User persistedUser, User persistedFollowUser){
        dataUser.put(persistedUser.getId(), persistedUser);
        dataUser.put(persistedFollowUser.getId(), persistedFollowUser);
    }

    public List<User> getUsers(Set<Integer> users){
        List<User> result = new ArrayList<>();
        users.forEach( x->{
                    result.add(this.getUser(x));
                });
        return result;
    }


    @Override
    public void createPost(Post post) {
       dataUser.get(post.getUserId()).getPosts().add(post);
    }

    private void loadInitialData() {

        Post post = new Post();
        post.setDate(LocalDate.now());
        post.setCategory(1);
        post.setPrice(100.0);
        post.setProduct(new Product());
        post.setHasPromo(true);
        post.setDiscount(10.0);


        User user1 = new User(1, "JavierRydel", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user2 = new User(2, "GastonBarro", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        user2.getPosts().add(post);
        User user3 = new User(3, "YaninaFaretta", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user4 = new User(4, "AdrianRodriguez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user5 = new User(5, "JoseGonzaloez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user6 = new User(6, "FlagusRodriguez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user7 = new User(7, "LeandroMarcelo", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user8 = new User(8, "GonzaloMarquez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user9 = new User(9, "MartinMarquez", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        User user10 = new User(10, "GabrielaMonzon", new HashSet<>(), new HashSet<>(), new ArrayList<>());

        dataUser.put(user1.getId(), user1);
        dataUser.put(user2.getId(), user2);
        dataUser.put(user3.getId(), user3);
        dataUser.put(user4.getId(), user4);
        dataUser.put(user5.getId(), user5);
        dataUser.put(user6.getId(), user6);
        dataUser.put(user7.getId(), user7);
        dataUser.put(user8.getId(), user8);
        dataUser.put(user9.getId(), user9);
        dataUser.put(user10.getId(), user10);
    }

    
}
