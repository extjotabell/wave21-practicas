package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.PostPromoDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PromoRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowerDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.PromoCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductsServiceImpl implements IProductsService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO postRequestDTO) {
        Post post = convertPostRequestDTOtoPost(postRequestDTO);
        try{
            if(!isValidRequest(postRequestDTO))
                throw new PostBadRequestException("Peticion de publicacion invalida.");

            userRepository.createPost(post);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado.");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listFollowingPosts2Weeks(int userId) {
        List<User> responseList;
        try{
            responseList = userRepository.listFollowingPosts2Weeks(userId);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado.");
        }
        List<PostDTO> postsDTO = new ArrayList<>();
        responseList.forEach(user -> {
            user.getPosts().forEach(post -> {
                postsDTO.add(convertPostToPostDTO(post));
            });
        });

        return ResponseEntity.ok(new UserPostResponseDTO(userId, postsDTO));
    }

    @Override
    public ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order) {
        List<User> responseList;
        try {
            responseList = userRepository.listFollowingPosts2Weeks(userId);
        } catch (NullPointerException e) {
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado.");
        }

        List<Post> postList = new ArrayList<>();

        responseList.forEach(user -> {
            postList.addAll(user.getPosts());
        });

        orderCollectionByOrderParam(postList, order);

        List<PostDTO> postsDTO = postList.stream().map(this::convertPostToPostDTO).toList();

        return ResponseEntity.ok(postsDTO);
    }

    private void orderCollectionByOrderParam(List<Post> collection, String order) {
        if (order.equalsIgnoreCase(Constants.ORDER_DATE_ASC)) {
            collection.sort(Comparator.comparing(Post::getDate));
        } else if (order.equalsIgnoreCase(Constants.ORDER_DATE_DESC)) {
            collection.sort(Comparator.comparing(Post::getDate).reversed());
        }
    }


    private UserPostResponseDTO convertUserToUserPostResponseDTO(User user) {
        List<PostDTO> postsDTO = new ArrayList<>();
        user.getPosts().forEach(postDTO -> {
            postsDTO.add(convertPostToPostDTO(postDTO));
        });
        return new UserPostResponseDTO(user.getId(),postsDTO);
    }

    private PostDTO convertPostToPostDTO(Post post){
        return new PostDTO(post.getUserId(),post.getPostId(),convertLocalDateToString(post.getDate()),
                convertProductToProductDTO(post.getProduct()),post.getCategory(),post.getPrice());
    }

    private ProductDTO convertProductToProductDTO(Product product){
        return new ProductDTO(product.getProductId(),product.getProductName(),product.getBrand(), product.getType(),
               product.getColor(), product.getNotes());
    }

    private boolean isValidRequest(PostRequestDTO postRequestDTO){
        LocalDate date = convertStringToLocalDate(postRequestDTO.getDate());
        return postRequestDTO.getDate() != null && (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now()))
                && postRequestDTO.getPrice() >= 0;
    }

    private boolean isValidRequestPromo(PromoRequestDTO promoRequestDTO){
        LocalDate date = convertStringToLocalDate(promoRequestDTO.getDate());
        return promoRequestDTO.getDate() != null && (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now()))
                && promoRequestDTO.getPrice() >= 0 && promoRequestDTO.isHasPromo() == true && promoRequestDTO.getDiscount() > 0;
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

    private String convertLocalDateToString(LocalDate date){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(dateFormatter);
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


    private Post convertPostRequestPromoDTOtoPost(PromoRequestDTO promoRequestDTO){
        Post post = new Post();
        post.setUserId(promoRequestDTO.getUserId());

        post.setDate(convertStringToLocalDate(promoRequestDTO.getDate()));
        post.setCategory(promoRequestDTO.getCategory());
        post.setPrice(promoRequestDTO.getPrice());
        post.setProduct(convertProductDTOtoProduct(promoRequestDTO.getProduct()));
        post.setHasPromo(promoRequestDTO.isHasPromo());
        post.setDiscount(promoRequestDTO.getDiscount());
        return post;
    }

    private PostPromoDTO convertPostToPromoDTO(Post post){
        return new PostPromoDTO(post.getUserId(),post.getPostId(),convertLocalDateToString(post.getDate()),
                convertProductToProductDTO(post.getProduct()),post.getCategory(),post.getPrice(),post.isHasPromo(),post.getDiscount());
    }


    public ResponseEntity<?> createPostHasPromo(PromoRequestDTO promoRequestDTO) {
        Post post = convertPostRequestPromoDTOtoPost(promoRequestDTO);
        try{
            if(!isValidRequestPromo(promoRequestDTO))
                throw new PostBadRequestException("Peticion de publicacion invalida.");

            userRepository.createPost(post);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado.");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public PromoCountDTO getPostCount(int userId){
        try {
            User persistedUser = userRepository.getUser(userId);

            int count = (int) persistedUser.getPosts().stream()
                    .filter(post -> post.isHasPromo())
                    .count();

            return new PromoCountDTO(
                    persistedUser.getId(),
                    persistedUser.getUsername(),
                    count);
        } catch (NullPointerException e) {
            throw new UserNotFoundException("El userId no existe en el repositorio");
        }
    }

}
