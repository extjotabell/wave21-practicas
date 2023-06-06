package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
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
    private IUserRepository userRepository;
    private ModelMapper modelMapper;
    public PostService(IPostRepository postRepository, IUserRepository userRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    private List<Post> getFollowedPosts(final int userId) {
        List<User> followed = userRepository.getFollowedByUser(userId);

        List<Post> posts = new ArrayList<>();

        followed.forEach(user -> {
          posts.addAll(postRepository.getPostsByUserInTwoWeeks(user.getId()));
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
}
