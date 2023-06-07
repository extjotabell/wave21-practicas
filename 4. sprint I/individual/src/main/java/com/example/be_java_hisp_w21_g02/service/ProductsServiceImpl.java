package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.CreatePromoPostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowerDTO;
import com.example.be_java_hisp_w21_g02.dto.response.PromoPostCountDto;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

        System.out.println("responseList.isEmpty()");
        System.out.println(responseList.isEmpty());

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



    // ? US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    private Post convertCreatePromoPostDtotoPost(CreatePromoPostDTO createPromoPostDTO){
        Post post = new Post();
        BeanUtils.copyProperties(createPromoPostDTO, post);
        post.setDate(convertStringToLocalDate(createPromoPostDTO.getDate()));
        post.setProduct(convertProductDTOtoProduct(createPromoPostDTO.getProduct()));
        return post;

    }

    // ? US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    public void createPromoPost(CreatePromoPostDTO createPromoPostDTO) {
        Post post = convertCreatePromoPostDtotoPost(createPromoPostDTO);
        userRepository.createPost(post);
        return;
    }

    @Override
    public List<Post> getAllPosts() {
        // create me a set of integers de userId 1,2,3,4,5,6,7
        Set <Integer> userIds = new HashSet<>();
        userIds.add(1);
        userIds.add(2);
        userIds.add(3);
        userIds.add(4);
        userIds.add(5);
        userIds.add(6);
        userIds.add(7);
        userIds.add(8);
        userIds.add(9);
        userIds.add(10);

        List<Post> allPosts = new ArrayList<>();

        userRepository.getUsers(userIds).forEach(user -> {
            allPosts.addAll(user.getPosts());
        });

        return allPosts;
    }

    @Override
    public PromoPostCountDto getPromoPostCount(int userId) {
        User foundUser = userRepository.getUser(userId);
        if (foundUser == null) {
            throw new UserNotFoundException("User not found");
        }

        int promoPostCount = 0;

        for (Post post : foundUser.getPosts()) {
            if (post.isHasPromo()) {
                promoPostCount += 1;
            }
        }

        PromoPostCountDto promoPostCountDto = new PromoPostCountDto();
        promoPostCountDto.setUserId(userId);
        promoPostCountDto.setUserName(foundUser.getUsername());
        promoPostCountDto.setPromoProductsCount(promoPostCount);
        return promoPostCountDto;
    }


}
