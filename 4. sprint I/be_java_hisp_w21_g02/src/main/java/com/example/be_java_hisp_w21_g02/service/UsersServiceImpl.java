package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements IUsersService{

    @Autowired
    private IUserRepository _usersRepository;

    public void followUser(int userId, int userIdToFollow){
        // Traerme del Repositorio al userIdToFollow por ID
        User persistedUser = _usersRepository.getUser(userIdToFollow);
        if(persistedUser == null){
            //exploto
        }

        // Validar que el userIdToFollow pertenezca a un vendedor
        if (!persistedUser.isSeller()){

        }

        // Es vendedor, generamos los follows.
        // .. Procedimiento de follow
    }

}
