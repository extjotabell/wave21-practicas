package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import com.example.be_java_hisp_w21_g02.utils.DateConverter;
import com.example.be_java_hisp_w21_g02.utils.ExceptionChecker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductsServiceImpl implements IProductsService{

    private final IUserRepository _userRepository;

    public ProductsServiceImpl(IUserRepository userRepository) {
        this._userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO postRequestDTO) {
        Post post = convertPostRequestDTOtoPost(postRequestDTO);
        try{
            ExceptionChecker.checkBadRequestException(postRequestDTO);

            _userRepository.createPost(post);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listFollowingPosts2Weeks(int userId) {
        List<User> responseList;
        try{
            responseList = _userRepository.listFollowingPosts2Weeks(userId);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
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
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
        }

        List<Post> postList = new ArrayList<>();

        responseList.forEach(user -> {
            postList.addAll(user.getPosts());
        });

        orderCollectionByOrderParam(postList, order);

        List<PostDTO> postsDTO = postList.stream().map(this::convertPostToPostDTO).toList();

        return ResponseEntity.ok(postsDTO);
    }

    /**
     * Orders a list of posts by date in ascending or descending order
     * @param collection List of posts to be ordered
     * @param order parameter to order the list by date in ascending or descending order
     */
    private void orderCollectionByOrderParam(List<Post> collection, String order) {
        if (order.equalsIgnoreCase(Constants.ORDER_DATE_ASC)) {
            collection.sort(Comparator.comparing(Post::getDate));
        } else if (order.equalsIgnoreCase(Constants.ORDER_DATE_DESC)) {
            collection.sort(Comparator.comparing(Post::getDate).reversed());
        }
    }

    private PostDTO convertPostToPostDTO(Post post){
        return new PostDTO(post.getUserId(),post.getPostId(), post.getDate(),
                convertProductToProductDTO(post.getProduct()),post.getCategory(),post.getPrice());
    }

    private ProductDTO convertProductToProductDTO(Product product){
        return new ProductDTO(product.getProductId(),product.getProductName(),product.getBrand(), product.getType(),
               product.getColor(), product.getNotes());
    }

    private Post convertPostRequestDTOtoPost(PostRequestDTO postRequestDTO){
        Post post = new Post();
        post.setUserId(postRequestDTO.getUserId());
        post.setDate( postRequestDTO.getDate());
        post.setCategory(postRequestDTO.getCategory());
        post.setPrice(postRequestDTO.getPrice());
        post.setProduct(convertProductDTOtoProduct(postRequestDTO.getProduct()));
        return post;
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
