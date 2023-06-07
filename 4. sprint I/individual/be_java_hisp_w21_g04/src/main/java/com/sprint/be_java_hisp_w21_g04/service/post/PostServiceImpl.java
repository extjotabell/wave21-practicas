package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.EmptySellerFollowedListException;
import com.sprint.be_java_hisp_w21_g04.exception.NotFoundProductsPromoException;
import com.sprint.be_java_hisp_w21_g04.exception.PostAlreadyExistException;
import com.sprint.be_java_hisp_w21_g04.exception.UserNotFoundException;
import com.sprint.be_java_hisp_w21_g04.repository.post.IPostRepository;
import com.sprint.be_java_hisp_w21_g04.repository.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService{
    private IPostRepository _repository;
    private IUserRepository _userRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(IPostRepository repository, IUserRepository userRepository){
        this._repository = repository;
        this._userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public ResponseDto post(PostRequestDto post) {
        System.out.println(2);
        System.out.println(post);
        List<PostResponseDto> posts = this._repository.getAll().stream().
                filter(post1 -> post1.getUserId() == post.getUserId() && post1.getDate().equals(post.getDate())
                        && post1.getProduct().getProductId() == post.getProduct().getProductId()
                        && post1.isHasPromo() == post.isHasPromo())
                .map(post1 -> modelMapper.map(post, PostResponseDto.class))
                .toList();
        if(!posts.isEmpty()) throw new PostAlreadyExistException("Ya existe un post para este producto");
        this._repository.post(modelMapper.map(post, Post.class));
        return new ResponseDto("Post agregado exitosamente");
    }

    @Override
    public List<PostResponseDto> getAll() {
        return this._repository.getAll().stream().map(post -> modelMapper.map(post, PostResponseDto.class)).toList();
    }

    @Override
    public SellerFollowedListPostResponseDto sellerFollowedListPosts(int userId, String order) {
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        System.out.println("HOLA" + twoWeeksAgo);
        if(this._repository.getSellerFollowed(userId).isEmpty()) throw new EmptySellerFollowedListException("Los vendedores que sigues no tienen publicaciones");
        List<PostResponseDto> posts = this._repository.getSellerFollowed(userId).stream()
                .filter(post -> {
                    LocalDate postDate = post.getDate();
                    return postDate.isAfter(twoWeeksAgo) || postDate.isEqual(twoWeeksAgo);
                })
                .map(post -> modelMapper.map(post, PostResponseDto.class))
                .sorted((post1, post2) -> {
                    LocalDate date1 = post1.getDate();
                    LocalDate date2 = post2.getDate();

                    if ("date_asc".equals(order)) {
                        return date1.compareTo(date2);
                    } else if ("date_desc".equals(order)) {
                        return date2.compareTo(date1);
                    } else {
                        return 0;
                    }
                })
                .collect(Collectors.toList());
        if(posts.isEmpty()) throw new EmptySellerFollowedListException("Los vendedores que sigues no han hecho publiciones en las últimas dos semanas");
        return new SellerFollowedListPostResponseDto(userId, posts);
    }

    @Override
    public QuantityProductsHasPromoResponse getQuantityProductsPromo(int userid) {
        QuantityProductsHasPromoResponse response = new QuantityProductsHasPromoResponse();
        User user = this._userRepository.findUserById(userid);
        long countQuantityProductsPromo = this._repository.getProductsPromo(userid).size();
        if(user == null) throw new UserNotFoundException("Usuario no existe");
        if(countQuantityProductsPromo == 0) throw new NotFoundProductsPromoException("Este usuario no tiene prductos en promoción");
        response.setUserId(userid);
        response.setUserName(user.getUserName());
        response.setPromoProductsCount(countQuantityProductsPromo);
        return response;
    }

    @Override
    public ListProductsHasPromoResponse getProductsPromo(int userid) {
        ListProductsHasPromoResponse response = new ListProductsHasPromoResponse();
        User user = this._userRepository.findUserById(userid);
        List<PostResponseDto> listProductsPromo = this._repository.getProductsPromo(userid).stream().map(post -> modelMapper.map(post, PostResponseDto.class)).toList();
        if(user == null) throw new UserNotFoundException("Usuario no existe");
        if(listProductsPromo.isEmpty()) throw new NotFoundProductsPromoException("Este usuario no tiene prductos en promoción");
        response.setUserId(userid);
        response.setUserName(user.getUserName());
        response.setPosts(listProductsPromo);
        return response;
    }
}
