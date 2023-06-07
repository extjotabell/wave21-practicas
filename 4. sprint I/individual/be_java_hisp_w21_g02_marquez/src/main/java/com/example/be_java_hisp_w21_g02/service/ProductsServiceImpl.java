package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostPromoDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.response.PromoProductListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.InvalidFilterParameterException;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.PromoPostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import com.example.be_java_hisp_w21_g02.utils.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductsServiceImpl implements IProductsService{

    @Autowired
    IUserRepository _usersRepository;

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO postRequestDTO) {
        Post post = convertPostRequestDTOtoPost(postRequestDTO);
        try{
            if(!isValidRequest(postRequestDTO))
                throw new PostBadRequestException(Constants.POST_REQUEST_NOT_VALID_MESSAGE);

            _usersRepository.createPost(post);
        }catch (NullPointerException e) {
            throw new UserNotFoundException(Constants.USER_NOT_FOUND_BY_ID_MESSAGE);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public void createPromoPost(PostPromoDTO postPromoDTO) {
        try {
            if(!isValidRequest(postPromoDTO))
                throw new PostBadRequestException(Constants.POST_REQUEST_NOT_VALID_MESSAGE);

            if (!isValidPromoRequest(postPromoDTO))
                throw new PromoPostBadRequestException(Constants.PROMO_POST_REQUEST_NOT_VALID_MESSAGE);

            Post promoPost = convertPromoPostDTOToPost(postPromoDTO);
            _usersRepository.createPost(promoPost);
        }
        catch (NullPointerException e){
            throw new UserNotFoundException(Constants.USER_NOT_FOUND_BY_ID_MESSAGE);
        }
    }

    private boolean isValidPromoRequest(PostPromoDTO postPromoDTO) {
        return (postPromoDTO.isHasPromo() && (postPromoDTO.getDiscount() >= 0));
    }

    @Override
    public PromoProductListDTO getPromoPostCount(int userId) {
        User persistedUser = _usersRepository.getUser(userId);
        Validations.checkUserAndSellerException(persistedUser);

        return new PromoProductListDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                (int) persistedUser.getPosts().stream()
                        .filter(Post::isHasPromo)
                        .count()
        );
    }

    @Override
    public ResponseEntity<?> getListProductsFilterByPrice(double minimumPrice, double maximumPrice) {
        if (minimumPrice < 0 && maximumPrice < 0)
            throw new InvalidFilterParameterException("Los rangos deben ser mayores a 0");

        List<Post> res = _usersRepository.getPostsByRange(minimumPrice, maximumPrice);

        List<PostDTO> result = new ArrayList<>();

        res.forEach(
                post -> result.add(convertPostToPostDTO(post))
        );

        return ResponseEntity.ok(result);
    }


    @Override
    public ResponseEntity<?> listFollowingPosts2Weeks(int userId) {
        List<User> responseList;
        try{
            responseList = _usersRepository.listFollowingPosts2Weeks(userId);
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
            responseList = _usersRepository.listFollowingPosts2Weeks(userId);
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

    private Post convertPromoPostDTOToPost(PostPromoDTO postPromoDTO) {
        Post promoPost = new Post();
        promoPost.setUserId(postPromoDTO.getUserId());
        promoPost.setDate(convertStringToLocalDate(postPromoDTO.getDate()));
        promoPost.setCategory(postPromoDTO.getCategory());
        promoPost.setPrice(postPromoDTO.getPrice());
        promoPost.setProduct(convertProductDTOtoProduct(postPromoDTO.getProduct()));
        promoPost.setHasPromo(postPromoDTO.isHasPromo());
        promoPost.setDiscount(postPromoDTO.getDiscount());

        return promoPost;
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
}
