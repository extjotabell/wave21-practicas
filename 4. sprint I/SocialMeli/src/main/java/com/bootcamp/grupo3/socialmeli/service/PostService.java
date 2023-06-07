package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PromoPostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PromoPostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PromoProductsCountDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.PromoPost;
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
    private static String NAME_ASC = "name_asc";
    private static String NAME_DESC = "name_desc";

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

    // Individual
    @Override
    public int createPromoPost(PromoPostDTO body) {
        Post newPost = modelMapper.map(body, PromoPost.class);
        if (userService.userExists(newPost.getUserId())) {
            return postRepository.createPost(newPost);
        } else {
            throw new UserNotFoundException("No se ha encontrado el usuario");
        }
    }
    @Override
    public PromoProductsCountDTO getPromoProductCount(int userId) {
        User user = userService.getUserByID(userId);
        List<Post> postList = postRepository.getPostsByUserInTwoWeeks(userId);
        List<PromoPost> promoList = postList.stream()
                .filter(t -> t instanceof PromoPost)
                .map(t->(PromoPost) t)
                .filter(t -> t.isHasPromo())
                .collect(Collectors.toList());
        int count = promoList.size();
        PromoProductsCountDTO promoProductsCountDTO = modelMapper.map(user,PromoProductsCountDTO.class);
        promoProductsCountDTO.setPromoProductsCount(count);

        return promoProductsCountDTO;
    }

    @Override
    public PromoPostListDTO getPromoPostList(final int userId, final String order) {
        //Comparator<Persona> c = Comparator.comparing(Persona::getNombre).thenComparing(Persona::getEdad);
        //Comparator<Post> c = Comparator.comparing(Post::getProduct);

        /*User user = userService.getUserByID(userId);
        List<Post> postList = postRepository.getPostsByUserInTwoWeeks(userId);
        List<PromoPost> promoList = postList.stream()
                .filter(t -> t instanceof PromoPost)
                .map(t->(PromoPost) t)
                .filter(t -> t.isHasPromo())
                .collect(Collectors.toList());
        PromoPostListDTO promoPostList = modelMapper.map(promoList, PromoPostListDTO.class);
        promoPostList.setUserName(user.getName());
        promoPostList.setUserId(userId);*/

        User user = userService.getUserByID(userId);
        List<Post> postList = postRepository.getPostsByUserInTwoWeeks(userId);
        List<PromoPost> promoList = postList.stream()
                .filter(t -> t instanceof PromoPost)
                .map(t->(PromoPost) t)
                .filter(t -> t.isHasPromo())
                .collect(Collectors.toList());
        PromoPostListDTO promoPostList = new PromoPostListDTO();
        promoPostList.setPromoPostList(promoList.stream().map(t-> modelMapper.map(t,PromoPostDTO.class)).toList());
        promoPostList.setUserName(user.getName());
        promoPostList.setUserId(userId);
        return promoPostList;
    }

}
