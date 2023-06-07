package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDiscountDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.*;
import com.example.be_java_hisp_w21_g1.Exception.BadRequestException;
import com.example.be_java_hisp_w21_g1.Exception.NotFoundException;
import com.example.be_java_hisp_w21_g1.Exception.UserNotSellerException;
import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import com.example.be_java_hisp_w21_g1.Utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    public boolean follow(FollowPostDTO followPostDTO){
        Optional<User> user = userRepository.findUserById(followPostDTO.getUserId());
        Optional<User> seller = userRepository.findUserById(followPostDTO.getUserIdToFollow());

        //validar que no esten null
        if(user.isEmpty() || seller.isEmpty()) throw new NotFoundException("Usuarios no encontrados...");

        //validar que sea vendedor el seller
        if(!seller.get().isSeller()) throw new UserNotSellerException("El usuario no es un vendedor...");

        //validar que no exista la relacion
        if (user.get().getFollowed().stream().anyMatch(followed -> followed.getUser_id() == seller.get().getUser_id())) return false;

        userRepository.relateUserAndSeller(user.get(),seller.get());
        return true;
    }

    public boolean unFollow(FollowPostDTO followPostDTO){
        Optional<User> user = userRepository.findUserById(followPostDTO.getUserId());
        Optional<User> seller = userRepository.findUserById(followPostDTO.getUserIdToFollow());

        //validar que no esten null
        if(user.isEmpty() || seller.isEmpty()) return false;

        //validar que exista la relacion
        if (!user.get().getFollowed().stream().anyMatch(followed -> followed.getUser_id() == seller.get().getUser_id())) return false;

        userRepository.unRelateUserAndSeller(user.get(), seller.get());
        return true;
    }

    @Override
    public FollowersCountDTO getFollowersCount(int idUser) {

        Optional<User> foundUser = userRepository.findUserById(idUser);
        if (foundUser.isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        int followersCount = user.followersCount();
        return new FollowersCountDTO(idUser, user.getUser_name(),followersCount);

    }

    @Override
    public FollowerListDTO getFollowersList(int idUser, String order) {
        Optional<User> foundUser = userRepository.findUserById(idUser);

        if (foundUser.isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        List<FollowUserDTO> followedList = user.getFollowers().stream()
                .map(u -> new FollowUserDTO(u.getUser_id(), u.getUser_name()))
                .toList();

        if(order != null){
            followedList = orderList(followedList, order);
        }

        return new FollowerListDTO(idUser, user.getUser_name(),followedList);
    }

    @Override
    public FollowedListDTO getFollowedList(int idUser, String order) {
//        name_asc
        Optional<User> foundUser = userRepository.findUserById(idUser);

        if (foundUser.isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        List<FollowUserDTO> followedList = user.getFollowed().stream()
                .map(u -> new FollowUserDTO(u.getUser_id(), u.getUser_name()))
                .toList();

        if(order != null){
            followedList = orderList(followedList, order);
        }

        return new FollowedListDTO(idUser, user.getUser_name(),followedList);
    }

    private List<FollowUserDTO> orderList(List<FollowUserDTO> list, String order) {
        if (order.equals("name_asc")) {
            return list.stream()
                    .sorted(Comparator.comparing(FollowUserDTO::getUser_name))
                    .toList();
        } else if(order.equals("name_desc")){
            return list.stream()
                    .sorted((o1, o2) -> o2.getUser_name().compareTo(o1.getUser_name()))
                    .toList();
        } else {
            throw new BadRequestException("El parametro order debe ser name_asc o name_desc");
        }
    }


    public void createPost(PostProductDTO postProductDTO) {
        Optional<User> user =userRepository.findUserById(postProductDTO.getUser_id());
        if(user.isEmpty()){
            throw new BadRequestException("No se encontro el usuario con el ID" + postProductDTO.getUser_id());
        }
        int postId = user.get().getPosts().size();
        Post post = Mapper.DTOtoPost(postProductDTO, postId);

        userRepository.addPostToUser(post, user.get());
    }

    public PostBySellerDTO listPostsBySeller(int userId, String alf_order) {
        LocalDate currentDate = LocalDate.now();

        Optional<User> userFound = userRepository.findUserById(userId);

        List<PostDTO> sellersPost = userFound
                .orElseThrow(
                        ()->new BadRequestException("No se encontro el usuario con el ID" + userId)
                )
                .getFollowed().stream()
                .flatMap(seller -> seller.getPosts()
                        .stream()
                        .filter(p -> p.isLatestPost(currentDate))
                ).map(Mapper::PostToPostDTO)
                .collect(Collectors.toList());

        if(alf_order != null){
            return orderList(Mapper.SellerPostToDTO(sellersPost, userId),alf_order);
        }

        return Mapper.SellerPostToDTO(sellersPost, userId);
    }

    private PostBySellerDTO orderList(PostBySellerDTO postBySellerDTO, String order) {
        if (order.equals("date_asc")) {
            return new PostBySellerDTO(
                        postBySellerDTO.getUser_id(),
                        postBySellerDTO.getPosts().stream()
                        .sorted(Comparator.comparing(PostDTO::getDate)).collect(Collectors.toList()));
        } else if(order.equals("date_desc")){
            return new PostBySellerDTO(postBySellerDTO.getUser_id(),
                    postBySellerDTO.getPosts().stream()
                            .sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate()))
                            .collect(Collectors.toList()));
        } else {
            throw new BadRequestException("El parametro order debe ser name_asc o name_desc");
        }
    }

    public void createPostProductWithDiscount (PostProductDiscountDTO productDiscountDTO)
    {
        Optional<User> user =userRepository.findUserById(productDiscountDTO.getUser_id());
        if(user.isEmpty()){
            throw new BadRequestException("No se encontro el usuario con el ID" + productDiscountDTO.getUser_id());
        }
        int postId = user.get().getPosts().size();
        Post post = Mapper.DTODiscountToPost(productDiscountDTO, postId);

        userRepository.addPostToUser(post, user.get());
    }

    public ProductCountDTO getDiscountProductCount(int idUser) {

        Optional<User> foundUser = userRepository.findUserById(idUser);
        if (foundUser.isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        int followersCount = user.productDiscountCount();
        return new ProductCountDTO(idUser, user.getUser_name(),followersCount);

    }
}
