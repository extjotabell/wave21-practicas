package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostResponseDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.exception.PostNotFoundException;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.order.PostDTOOrder;
import com.bootcamp.grupo3.socialmeli.order.PostOrderType;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IProductService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService implements IPostService {
    private static final String DATE_ASC = "date_asc";
    private static final String DATE_DES = "date_desc";
    private static final String PRICE_ASC = "price_asc";
    private static final String PRICE_DESC = "price_desc";

    private IPostRepository postRepository;
    private IUserService userService;
    private IProductService productService;
    private ModelMapper modelMapper;

    public PostService(
      IPostRepository postRepository,
      ModelMapper modelMapper,
      IUserService userService,
      IProductService productService
    ) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.productService = productService;
    }


    @Override
    public Post getPost(final Integer postId) {
        return postRepository.getPostById(postId)
          .orElseThrow(PostNotFoundException::new);
    }

    @Override
    public int createPost(final PostDTO body) throws UserPermissionException {
      if (!userService.userExists(body.getToken()))
        throw new UserPermissionException("No existe el usuario");

      int productId = productService.createProduct(body.getProduct());
      User u = userService.getUserByToken(body.getToken());

      Post newPost = new Post();

      newPost.setUserId(u.getId());
      newPost.setCategory(body.getCategory());
      newPost.setPrice(body.getPrice());
      newPost.setDate(body.getDate());
      newPost.setProductId(productId);

      return postRepository.createPost(newPost);
    }

    @Override
    public UserPostListDTO getPostList(final String token, final PostOrderType order) throws UserPermissionException {

        List<PostResponseDTO> followedPostDto = this.getFollowedPosts(token)
          .stream()
          .map(p -> new PostResponseDTO(
            p.getId(),
            p.getUserId(),
            p.getDate(),
            productService.getProductDtoById(p.getProductId()),
            p.getCategory(),
            p.getPrice())
          ).toList();

        PostDTOOrder postOrderable = new PostDTOOrder();
        Comparator<PostResponseDTO> c = postOrderable.getComparator(order);

        return new UserPostListDTO(
          userService.getUserByToken(token).getId(),
          followedPostDto
            .stream()
            .sorted(c)
            .toList()
        );
    }

    private List<Post> getFollowedPosts(final String token) throws UserPermissionException {
      List<Integer> followed = userService.getFollowedByUser(token);

      List<Post> posts = new ArrayList<>();

      followed.forEach(id -> {
        posts.addAll(postRepository.getPostsByUserInTwoWeeks(id));
      });

      return posts;
    }

    private Comparator<PostResponseDTO> getComparator(final String order) {
      if(DATE_ASC.equals(order))
        return Comparator.comparing(PostResponseDTO::date);
      else if(PRICE_ASC.equals(order))
        return Comparator.comparing(PostResponseDTO::price);
      else if(PRICE_DESC.equals(order))
        return Comparator.comparing(PostResponseDTO::price).reversed();

      return Comparator.comparing(PostResponseDTO::date).reversed();
    }
}
