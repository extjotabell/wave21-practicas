package com.example.be_java_hisp_w21_g1.Repository;

import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Model.Product;
import com.example.be_java_hisp_w21_g1.Model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository implements IUserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        init();
    }

    private void init() {

        Product product1 = new Product(1, "Producto1", "Type1", "Brand1", "Color1", "Notes1");
        Product product2 = new Product(2, "Producto2", "Type2", "Brand2", "Color2", "Notes2");
        Product product3 = new Product(3, "Producto3", "Type3", "Brand3", "Color3", "Notes3");

        Post post1 = new Post(1, 1, LocalDate.of(2023, 06, 04), product1, 1, 25.50,true,0.25);
        Post post2 = new Post(1, 2, LocalDate.of(2023, 05, 28), product2, 1, 15.90);
        Post post3 = new Post(1, 3, LocalDate.of(2022, 04, 04), product3, 1, 190.00);
        Post post4 = new Post(1, 4, LocalDate.of(2023, 05, 29), product2, 1, 90.90);

        // asList crea un array de tamaño fijo y tratamos de agregar mas cosas
        // List<Post> posts = Arrays.asList(post1, post2, post3, post4);
        // Revisar excepciones
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

        User user1 = new User(1, "Pepe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Pablo", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4, "USUARIO NUEVO", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());


        this.users.add(user1);
        this.users.add(user2);
        this.users.add(user3);

        ArrayList<User> followers1 = new ArrayList<>();
        followers1.add(user2);
        followers1.add(user3);
        user1.setFollowers(followers1);

        ArrayList<User> followed1 = new ArrayList<>();
        followed1.add(user2);
        followed1.add(user4);
        user1.setFollowed(followed1);
        user1.setPosts(posts);

    }

    @Override
    public Optional<User> findUserById(int id){
        return users.stream().filter(p-> p.getUser_id() == id).findFirst();
    }

    public void relateUserAndSeller(User user, User seller) {
        user.getFollowed().add(seller);
        seller.getFollowers().add(user);
    }

    public void addPostToUser(Post post, User user) {
        for (User usuario : users) {
            if (usuario.getUser_id() == user.getUser_id()) {
                List<Post> posteos = usuario.getPosts();
                posteos.add(post);
                usuario.setPosts(posteos);
            }
        }
    }

    public void unRelateUserAndSeller(User user, User seller){
        user.getFollowed().remove(seller);
        seller.getFollowers().remove(user);
    }


}
