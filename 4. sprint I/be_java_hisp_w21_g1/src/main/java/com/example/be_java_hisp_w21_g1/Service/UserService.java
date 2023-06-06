package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.UserIdDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowUserDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostBySellerDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostDTO;
import com.example.be_java_hisp_w21_g1.Exception.BadRequestException;
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


}
