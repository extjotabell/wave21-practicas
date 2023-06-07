package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostDiscountCountByUserDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
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

    public PostDiscountCountByUserDTO getPostsDiscountByUser(int userId ){
        User user = userService.getUserByID(userId);
        List<Post> listWithDiscount = postRepository.getHasDiscountList(userId);
        PostDiscountCountByUserDTO response = modelMapper.map(user, PostDiscountCountByUserDTO.class);
        response.setPromoProductsCount(listWithDiscount.size());
        return response;
    }



    @Override
    public PostListDTO getPostListHasDiscount(int userId){
        User user = userService.getUserByID(userId);
        if(user == null) throw new UserNotFoundException("el usuario no existe");
        PostListDTO response = modelMapper.map(user, PostListDTO.class);
        List<Post> hasDiscountList= postRepository.getHasDiscountList(userId);
        List<PostDTO> listaDTO = this.mapListToDTO(hasDiscountList);
        if(hasDiscountList.isEmpty()) throw new RuntimeException("El usuario no tiene posteos con Descuentos");
        response.setPosts(listaDTO);
        return response;




    }

    List<PostDTO> mapListToDTO (List<Post> lista){
        return lista.stream()
                .map(p -> {
                    PostDTO dto = modelMapper.map(p, PostDTO.class);
                    return dto;
                })
                .collect(Collectors.toCollection(ArrayList::new));

    }


}
