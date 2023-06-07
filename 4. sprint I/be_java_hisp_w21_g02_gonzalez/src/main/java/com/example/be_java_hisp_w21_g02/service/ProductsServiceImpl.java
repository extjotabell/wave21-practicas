package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.ProductWithPromoRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.CountPromoResponseDTO;
import com.example.be_java_hisp_w21_g02.dto.response.GenericResponseDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.inidvidual.PromoBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.inidvidual.UserNotFoundToAddException;
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

    private static final String BAD_REQUEST_PROMO = "Request is invalid";
    private static final String NOT_FOUND_USER_PROMO = "This user does not exist.";
    private static final String NOT_FOUND_USER_PROMO_EMPTY = "This user doesn't have promos";
    private static final String CREATED_PROMO = "Product with promo created successfully.";

    @Autowired
    IUserRepository _userRepository;

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO postRequestDTO) {
        Post post = convertPostRequestDTOtoPost(postRequestDTO);
        try{
            if(!isValidRequest(postRequestDTO))
                throw new PostBadRequestException("Peticion de publicacion invalida.");

            _userRepository.createPost(post);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado.");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listFollowingPosts2Weeks(int userId) {
        List<User> responseList;
        try{
            responseList = _userRepository.listFollowingPosts2Weeks(userId);
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
            responseList = _userRepository.listFollowingPosts2Weeks(userId);
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

    //INDIVIDUAL US0010
    /**
     * Returns a ResponseEntity with any result usually it'll be GenericResponseDTO
     *
     * @param productRequestDTO productRequestDTO
     * @return ResponseEntity with an object type GenericResponseDTO like body
     */
    @Override
    public ResponseEntity<?> createProductWithPromo(ProductWithPromoRequestDTO productRequestDTO) {
        if(isInvalidRequest(productRequestDTO)){
            throw new PromoBadRequestException(BAD_REQUEST_PROMO);
        }
        Post post = convertProductWithPromoRequestDTOtoPost(productRequestDTO);
        Post responseRepository = _userRepository.createProductWithPromo(post);
        if(responseRepository == null){
            throw new UserNotFoundToAddException(NOT_FOUND_USER_PROMO);
        }
        return new ResponseEntity<>(getGenericResponseDTO(200, CREATED_PROMO), HttpStatus.OK);
    }

    //INDIVIDUAL US0011
    /**
     * Returns a ResponseEntity with any result usually it'll be CountPromoResponseDTO
     *
     * @param  int  userId
     * @return      ResponseEntity with an object type CountPromoResponseDTO like body
     */
    @Override
    public ResponseEntity<?> getProductsWithPromoByUserId(int userId) {
        User responseRepository = _userRepository.getProductsWithPromoByUserId(userId);
        if(responseRepository == null ){
            throw new UserNotFoundToAddException(NOT_FOUND_USER_PROMO);
        } else if (responseRepository.getPosts().isEmpty()){
            throw new UserNotFoundToAddException(NOT_FOUND_USER_PROMO_EMPTY);
        }
        return new ResponseEntity<>(getCountPromoResponseDTO(responseRepository), HttpStatus.OK);
    }

    /**
     * @param code
     * @param message
     * @return GenericResponseDTO
     */
    private GenericResponseDTO getGenericResponseDTO(int code, String message){
        return new GenericResponseDTO(code, message);
    }

    /**
     * @param productDTO
     * @return boolean
     */
    private boolean isInvalidRequest(ProductWithPromoRequestDTO productDTO){
        return !productDTO.isHasPromo() || productDTO.getProduct() == null || productDTO.getProduct().getProductName()
                == null || productDTO.getDiscount() <= 0;
    }

    /**
     * @param postDTO
     * @return Post entity
     */
    private Post convertProductWithPromoRequestDTOtoPost(ProductWithPromoRequestDTO postDTO){
        Post post = new Post();
        post.setUserId(postDTO.getUserId());

        post.setDate(convertStringToLocalDate(postDTO.getDate()));
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());
        post.setProduct(convertProductDTOtoProduct(postDTO.getProduct()));
        post.setHasPromo(postDTO.isHasPromo());
        post.setDiscount(postDTO.getDiscount());
        return post;
    }

    /**
     * @param user
     * @return CountPromoResponseDTO
     */
    private CountPromoResponseDTO getCountPromoResponseDTO(User user){
        return new CountPromoResponseDTO(user.getId(), user.getUsername(), user.getPosts().size());
    }
}