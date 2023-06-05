package com.example.be_java_hisp_w21_g1.Repository;

import com.example.be_java_hisp_w21_g1.Model.Product;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class UserRepository implements IUserRepository{

    private List<User> users = new ArrayList<>();

    public void IUserRepository(){
        init();
    }

    private void init() {

        Product product1 = new Product(1, "Producto1", "Type1", "Brand1", "Color1", "Notes1");
        Product product2 = new Product(2, "Producto2", "Type2", "Brand2", "Color2", "Notes2");
        Product product3 = new Product(3, "Producto3", "Type3", "Brand3", "Color3", "Notes3");

        Post post1 = new Post(1, LocalDate.of(2023, 04, 15), product1, 25.50, 1);
        Post post2 = new Post(2, LocalDate.of(2022, 12, 27), product2, 15.90, 2);
        Post post3 = new Post(3, LocalDate.of(2023, 06, 04), product3, 190.00, 1);
        
        List<Product> products = Arrays.asList(product1, product2, product3);
        List<Post> posts = Arrays.asList(post1, post2, post3);

        User user1 = new User(1, "Pepe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Pablo", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public User findUserById(int id){
        return null;
    }

}
