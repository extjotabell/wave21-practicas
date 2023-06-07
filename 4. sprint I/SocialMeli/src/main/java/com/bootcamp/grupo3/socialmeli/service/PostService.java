package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PostWithPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.ListPostWithPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostWithPromo;
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

@Service
public class PostService implements IPostService {
    private static final String DATE_ASC = "date_asc";
    private static final String DATE_DES = "date_desc";
    private static final String PRICE_ASC = "price_asc";
    private static final String PRICE_DESC = "price_desc";
    private static final String DISC_ASC = "disc_asc";
    private static final String DISC_DESC = "disc_desc";

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

    @Override
    public int createPostWithPromo(PostWithPromoDTO body){
        Post newPost = modelMapper.map(body, Post.class);
        if (userService.userExists(newPost.getUserId())) {
            return postRepository.createPost(newPost);
        } else {
            throw new UserNotFoundException("No se ha encontrado el usuario");
        }

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

    private Comparator<PostWithPromoDTO> getPromoComparator(final String order) {
        if(DATE_ASC.equals(order))
            return Comparator.comparing(PostWithPromoDTO::getDate);
        else if(PRICE_ASC.equals(order))
            return Comparator.comparing(PostWithPromoDTO::getPrice);
        else if(DISC_ASC.equals(order))
            return Comparator.comparing(PostWithPromoDTO::getDiscount);
        else if(PRICE_DESC.equals(order))
            return Comparator.comparing(PostWithPromoDTO::getPrice).reversed();
        else if(DISC_DESC.equals(order))
            return Comparator.comparing(PostWithPromoDTO::getDiscount).reversed();
        return Comparator.comparing(PostWithPromoDTO::getDate).reversed();
    }

    @Override
    public UserPostWithPromo getPostWithPromoByUser(final int userId) {
        if (userService.userExists(userId)) {

            return new UserPostWithPromo(userId, userService.getUserByID(userId).getName(), postRepository.getCountPostWithPromosByUser(userId));
        } else {
            throw new UserNotFoundException("No se ha encontrado el usuario");
        }

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
    public ListPostWithPromoDTO getPostListWithPromo(final int userId, final String order) {

        User user = this.userService.getUserByID(userId);
        List<PostWithPromoDTO> listPostWithPromo = this.postRepository.getListPostWithPromo(userId)
                .stream()
                .map(p -> modelMapper.map(p, PostWithPromoDTO.class))
                .toList();

        Comparator<PostWithPromoDTO> c = this.getPromoComparator(order);

        return new ListPostWithPromoDTO(
                user.getId(),
                user.getName(),
                listPostWithPromo
                        .stream()
                        .sorted(c)
                        .toList()
        );
    }
}
