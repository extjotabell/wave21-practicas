package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PostOnSaleDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostOnSaleUserDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PromoCountDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.PostOnSale;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    private static String DATE_ASC = "date_asc";
    private static String DATE_DES = "date_desc";
    private static String PRICE_ASC = "price_asc";
    private static String PRICE_DESC = "price_desc";

    private static final String NAME_ASC="name_asc";

    private static final String NAME_DESC= "name_desc";

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

        List<Post> followedPosts = this.getFollowedPosts(userId);

        List<PostDTO> followedPostDto= new ArrayList<>();

        followedPosts.forEach(f -> {
            if(f instanceof PostOnSale)
                followedPostDto.add(modelMapper.map(f, PostOnSaleDTO.class));
            else if(f instanceof Post)
                followedPostDto.add(modelMapper.map(f,PostDTO.class));
        });

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
    public MessageDTO createPostOnSale(PostOnSaleDTO postOnSaleDTO) {
        PostOnSale newPost = modelMapper.map(postOnSaleDTO, PostOnSale.class);
        if (userService.userExists(newPost.getUserId())) {
            int id=postRepository.createPostOnSale(newPost);
            return new MessageDTO("Post agregado exitosamente con id: " + id);
        } else {
            throw new UserNotFoundException("No se ha encontrado el usuario");
        }
    }

    @Override
    public PromoCountDTO countProductsOnSale(int userId) {
        if(!userService.userExists(userId))
            throw new UserNotFoundException("No se ha encontrado el usuario");
        List<PostOnSale> postsOnSaleResponse = postRepository.getPostsOnSaleByUserId(userId);
        String userName=userService.getUserName(userId);
        return new PromoCountDTO(userId,userName,postsOnSaleResponse.size());
    }

    @Override
    public PostOnSaleUserDTO getPromoPostByUserId(int userId,String order) {
        if(!userService.userExists(userId))
            throw new UserNotFoundException("No se ha encontrado el usuario");
        List<PostOnSaleDTO> postOnSaleDTOResponse= postRepository.getPostsOnSaleByUserId(userId)
                .stream().map(postOnSale -> modelMapper.map(postOnSale,PostOnSaleDTO.class))
                .sorted(((o1, o2) -> {
                    if(order.equals(NAME_ASC))
                        return o1.getProduct().getProductName().compareTo(o2.getProduct().getProductName());
                    else if(order.equals(NAME_DESC))
                        return o2.getProduct().getProductName().compareTo(o1.getProduct().getProductName());
                    else
                        return 0;
                }))
                .collect(Collectors.toList());

        String userName= userService.getUserName(userId);
        return new PostOnSaleUserDTO(userId,userName,postOnSaleDTOResponse);
    }
}
