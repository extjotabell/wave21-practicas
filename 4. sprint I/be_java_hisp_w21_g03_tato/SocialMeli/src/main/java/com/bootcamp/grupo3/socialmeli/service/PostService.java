package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PromotionPostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.TrendingPostsDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPromoPostCountDTO;
import com.bootcamp.grupo3.socialmeli.exception.PostNotFoundException;
import com.bootcamp.grupo3.socialmeli.exception.PromotionPostException;
import com.bootcamp.grupo3.socialmeli.exception.UserAlreadyLikeException;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    private static String DATE_ASC = "date_asc";
    private static String DATE_DES = "date_desc";
    private static String PRICE_ASC = "price_asc";
    private static String PRICE_DESC = "price_desc";

    private IPostRepository postRepository;
    private IUserService userService;
    private ModelMapper modelMapper;

    public PostService(IPostRepository postRepository, ModelMapper modelMapper, IUserService userService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    public int createPost(PostDTO body) {
        Post newPost = modelMapper.map(body, Post.class);

        if (userService.userExists(newPost.getUserId())) {
            return postRepository.createPost(newPost);
        } else {
            throw new UserNotFoundException("No se ha encontrado el usuario");
        }
    }

    public int createPromotionPost(PromotionPostDTO postDTO){
        Post post = modelMapper.map(postDTO, Post.class);

        if(!post.isHasPromo()) throw new PromotionPostException("El post ingresado no esta en promoción");
        if(post.getDiscount() <= 0) throw new PromotionPostException("El post ingresado no cuenta con un descuento valido");
        if(!userService.userExists(post.getUserId())) throw new UserNotFoundException("No se ha encontrado el usuario");

        return postRepository.createPost(post);
    }

    private List<Post> getFollowedPosts(final int userId) {
        List<Integer> followed = userService.getFollowedByUser(userId);

        List<Post> posts = new ArrayList<>();

        followed.forEach(id -> {
          posts.addAll(postRepository.getPostsByUserInTwoWeeks(id));
        });

        return posts;
    }

    private Comparator<PostDTO> getComparator(final String order) {
      if(DATE_ASC.equals(order))
        return Comparator.comparing(PostDTO::getDate);
      else if(PRICE_ASC.equals(order))
        return Comparator.comparing(PostDTO::getPrice);
      else if(PRICE_DESC.equals(order))
        return Comparator.comparing(PostDTO::getPrice).reversed();

      return Comparator.comparing(PostDTO::getDate).reversed();
    }

    @Override
    public UserPostListDTO getPostList(final int userId, final String order) {

        List<PostDTO> followedPostDto = this.getFollowedPosts(userId)
          .stream()
          .map(p -> modelMapper.map(p, PostDTO.class))
          .toList();

        Comparator<PostDTO> c = this.getComparator(order);

        return new UserPostListDTO(
          userId,
          followedPostDto
            .stream()
            .sorted(c)
            .toList()
        );
    }

    @Override
    public UserPromoPostCountDTO getListOfPromotionPost(int userId) {
        User user = userService.getUserByID(userId);

        return new UserPromoPostCountDTO(user.getId(), user.getName(), postRepository.getPromotionPost(userId).size());
    }

    @Override
    public MessageDTO like(int userId, int postId) {
        if(!userService.userExists(userId)) throw new UserNotFoundException("No se ha encontrado el usuario");

        Post post = this.getPostById(postId);
        if(post.getLikes().contains(userId)) throw new UserAlreadyLikeException("El usuario ya le dio like a este post");

        post.getLikes().add(userId);
        return new MessageDTO("El usuario dio like correctamente!");
    }

    @Override
    public MessageDTO unlike(int userId, int postId) {
        if(!userService.userExists(userId)) throw new UserNotFoundException("No se ha encontrado el usuario");

        Post post = this.getPostById(postId);
        if(!post.getLikes().contains(userId)) throw new UserAlreadyLikeException("El usuario no le dio like a este post");

        post.getLikes().remove(userId);
        return new MessageDTO("El usuario saco el like correctamente!");
    }

    @Override
    public TrendingPostsDTO getTrendingPosts(int amount, String order) {
        List<Post> posts = new ArrayList<>(postRepository.getAll());
        posts.sort(Comparator.comparing(Post::getLikeSize).reversed());

        List<PostDTO> trendingPosts = posts.subList(0, Math.min(amount, posts.size()))
                .stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());

        if(DATE_ASC.equals(order)) trendingPosts.sort(Comparator.comparing(PostDTO::getDate));
        else if(DATE_DES.equals(order)) trendingPosts.sort(Comparator.comparing(PostDTO::getDate).reversed());

        return new TrendingPostsDTO(trendingPosts);
    }

    private Post getPostById(int postId){
        return postRepository.getPostById(postId)
                .orElseThrow(() -> new PostNotFoundException("No se ha encontrado el post"));
    }
}
