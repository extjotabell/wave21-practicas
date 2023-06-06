package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements IProductsService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO postRequestDTO) {
        Post post = convertPostRequestDTOtoPost(postRequestDTO);
        try{
            userRepository.createPost(post);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado.");
        }

        if(!isValidRequest(postRequestDTO)){
            throw new PostBadRequestException("Peticion de publicacion invalida.");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listFollowingPosts2Weeks(int userId) {
        List<UserPostResponseDTO> result = new ArrayList<>();
        List<User> responseList;
        try{
            responseList = userRepository.listFollowingPosts2Weeks(userId);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado.");
        }

        responseList.forEach(user -> {
            result.add(new UserPostResponseDTO(user.getId(), convertUserToUserPostResponseDTO(user).getPosts()));
        });

        return ResponseEntity.ok(result);
    }
    

    private UserPostResponseDTO convertUserToUserPostResponseDTO(User user) {
        List<PostDTO> postsDTO = new ArrayList<>();
        user.getPosts().forEach(postDTO -> {
            postsDTO.add(convertPostToPostDTO(postDTO));
        });
        return new UserPostResponseDTO(user.getId(),postsDTO);
    }

    private PostDTO convertPostToPostDTO(Post post){
        return new PostDTO(post.getUserId(),post.getPostId(),post.getDate(),
                convertProductToProductDTO(post.getProduct()),post.getCategory(),post.getPrice());
    }

    private ProductDTO convertProductToProductDTO(Product product){
        return new ProductDTO(product.getProductId(),product.getProductName(),product.getBrand(), product.getType(),
               product.getColor(), product.getNotes());
    }

    private boolean isValidRequest(PostRequestDTO postRequestDTO){
        return postRequestDTO.getDate() != null && convertStringToLocalDate(postRequestDTO.getDate())
                .isBefore(LocalDate.now()) && postRequestDTO.getPrice() >= 0;
    }

    private Post convertPostRequestDTOtoPost(PostRequestDTO postRequestDTO){
        Post post = new Post();
        post.setUserId(postRequestDTO.getUserId());
   
        post.setDate(convertStringToLocalDate(postRequestDTO.getDate()));
        post.setCategory(postRequestDTO.getCategory());
        post.setPrice(postRequestDTO.getPrice());
        post.setProduct(convertProductDTOtoProduct(postRequestDTO.getProduct()));
        return post;
    }

    private LocalDate convertStringToLocalDate(String date){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, dateFormatter);
    }



    private Product convertProductDTOtoProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setType(productDTO.getType());
        product.setBrand(productDTO.getBrand());
        product.setNotes(productDTO.getNotes());
        product.setColor(productDTO.getColor());
        return product;
    }
}
