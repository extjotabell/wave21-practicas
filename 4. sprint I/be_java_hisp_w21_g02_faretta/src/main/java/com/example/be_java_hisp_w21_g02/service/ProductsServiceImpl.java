package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PromoPostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.ExceptionChecker;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.PostNotFoundException;
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
import java.util.Optional;

@Service
public class ProductsServiceImpl implements IProductsService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO postRequestDTO) {
        if(!isValidRequest(postRequestDTO))
            throw new PostBadRequestException("Peticion de publicacion invalida.");

        Post post = convertPostRequestDTOtoPost(postRequestDTO);

        addPost(post);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> createPost(PromoPostRequestDTO postRequestDTO) {
        if(!isPromo(postRequestDTO) || !isValidRequest(postRequestDTO)){
            throw new PostBadRequestException("Peticion de publicacion invalida.");
        }

        Post post = convertPostRequestDTOtoPost(postRequestDTO);

        addPost(post);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> countPromoPosts(int userId) {
        User persistedUser = userRepository.getUser(userId);

        ExceptionChecker.checkUserAndSellerException(persistedUser);

        long promoPostsCount = persistedUser.getPosts().stream()
                .filter(Post::isHasPromo).count();

        PromoPostCountDTO promoPostCountDTO = new PromoPostCountDTO(persistedUser.getId(), persistedUser.getUsername(), promoPostsCount);
        return ResponseEntity.ok(promoPostCountDTO);
    }

    @Override
    public ResponseEntity<?> removePost(int userId, int postId) {
        User user = userRepository.getUser(userId);
        ExceptionChecker.checkUserException(user);
        List<Post> posts = user.getPosts();

        Post postToRemove = posts.stream().filter(post -> post.getPostId() == postId).findFirst().orElse(null);
        if(postToRemove == null){
            throw new PostNotFoundException("No existe un post con id " + postId + " del usuario " + userId);
        }
        posts.remove(postToRemove);
        user.setPosts(posts);
        userRepository.persistUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private boolean isPromo(PromoPostRequestDTO postRequestDTO) {

        return (postRequestDTO.isHasPromo() && postRequestDTO.getDiscount() > 0D);
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

    private Post convertPostRequestDTOtoPost(PostRequestDTO postRequestDTO){
        Post post = new Post();
        post.setUserId(postRequestDTO.getUserId());

        post.setDate(convertStringToLocalDate(postRequestDTO.getDate()));
        post.setCategory(postRequestDTO.getCategory());
        post.setPrice(postRequestDTO.getPrice());
        post.setProduct(convertProductDTOtoProduct(postRequestDTO.getProduct()));

        return post;
    }
    private Post convertPostRequestDTOtoPost(PromoPostRequestDTO postRequestDTO){
        Post post = convertPostRequestDTOtoPost((PostRequestDTO) postRequestDTO);
        post.setHasPromo(postRequestDTO.isHasPromo());
        post.setDiscount(postRequestDTO.getDiscount());
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

    private void addPost(Post post){
        try{
            userRepository.createPost(post);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado.");
        }
    }
}
