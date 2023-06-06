package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.UserIdDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostBySellerDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.PostDTO;
import com.example.be_java_hisp_w21_g1.Exception.BadRequestException;
import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import com.example.be_java_hisp_w21_g1.Utils.DateFormatter;
import com.example.be_java_hisp_w21_g1.Utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    public void createPost(PostProductDTO postProductDTO) {
        /*int postId = userRepository.findUserById(postProductDTO.getUser_id())
                .getPosts().size();
        Post post = Mapper.DTOtoPost(postProductDTO, postId);
        userRepository.addPostToUser(post, postProductDTO.getUser_id());*/
    }


    public PostBySellerDTO listPostsBySeller(int userId) {
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
        return Mapper.SellerPostToDTO(sellersPost, userId);
    }
}
