package com.example.be_java_hisp_w21_g02.repository;

import com.example.be_java_hisp_w21_g02.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    private HashMap<Integer, User> dataUser = new HashMap<>();

    public UserRepositoryImpl(List<User> dataUser) {
        loadInitialData();
        // comentario para probar PRS
    }



    private void loadInitialData() {
        User user1 = new User(1, "JavierRydel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "GastonBarro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "YaninaFaretta", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4, "AdrianRodriguez", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user5 = new User(5, "JoseGonzaloez", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user6 = new User(6, "FlagusRodriguez", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user7 = new User(7, "LeandroSupanta", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user8 = new User(8, "GonzaloMarquez", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user9 = new User(9, "MartinMarquez", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user10 = new User(10, "GabrielaMonzon", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

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
