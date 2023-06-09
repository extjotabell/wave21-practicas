package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.PostPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostIdPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostPromoMetricDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.PostPromo;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostPromoRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostPromoService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostPromoService implements IPostPromoService {

  private IPostPromoRepository postPromoRepository;
  private IPostService postService;
  private IUserService userService;
  private ModelMapper modelMapper;

  public PostPromoService(
    IPostPromoRepository postPromoRepository,
    IPostService postService,
    IUserService userService,
    ModelMapper modelMapper
  ) {
    this.postPromoRepository = postPromoRepository;
    this.postService = postService;
    this.userService = userService;
    this.modelMapper = modelMapper;
  }

  @Override
  public PostIdPromoDTO createPostPromo(final PostPromoDTO p) throws UserPermissionException {

    double discount = p.hasPromo() ? p.discount() : 0d;

    PostDTO post = new PostDTO(p.token(), p.date(), p.product(), p.category(), p.price());

    int idPost = postService.createPost(post);

    PostPromo promo = new PostPromo(p.hasPromo(), discount);
    promo.setPostId(idPost);

    return new PostIdPromoDTO(postPromoRepository.save(promo));
  }

  @Override
  public PostPromoMetricDTO getMetricPostPromo(final String token) throws UserPermissionException {
    User user = userService.getUserByToken(token);

    List<Integer> postIds = postPromoRepository.findAllPromosByUser(user.getId());

    int numberOfPostPromo = (int) postIds
      .stream()
      .map(postService::getPost)
      .filter(p -> p.getUserId() == user.getId())
      .count();

    return new PostPromoMetricDTO(
      user.getId(),
      user.getName(),
      numberOfPostPromo
    );

  }

}
