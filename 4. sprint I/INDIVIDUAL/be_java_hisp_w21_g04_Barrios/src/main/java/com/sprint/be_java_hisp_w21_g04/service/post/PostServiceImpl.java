package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PromoPostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.EmptySellerFollowedList;
import com.sprint.be_java_hisp_w21_g04.exception.PostAlreadyExist;
import com.sprint.be_java_hisp_w21_g04.exception.UserNotFoundException;
import com.sprint.be_java_hisp_w21_g04.repository.post.IPostRepository;
import com.sprint.be_java_hisp_w21_g04.repository.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    private IPostRepository _postRepository;
    private IUserRepository _userRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(IPostRepository postRepository, IUserRepository userRepository) {
        this._postRepository = postRepository;
        this._userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ResponseDto post(PostRequestDto post) {

        getUserDto(post.getUserId());

        List<PostResponseDto> posts = this._postRepository.getAll()
                                                       .stream()
                                                       .filter(post1 -> post1.getUserId() == post.getUserId()
                                                                     && post1.getDate().equals(post.getDate())
                                                                     && post1.getProduct().getProductId() == post.getProduct().getProductId())
                                                       .map(post1 -> modelMapper.map(post, PostResponseDto.class))
                                                       .toList();
        if (!posts.isEmpty()) throw new PostAlreadyExist("Ya existe un post para este producto");
        this._postRepository.post(modelMapper.map(post, Post.class));

        ResponseDto postResponseDto = new ResponseDto();
        postResponseDto.setMessage("Post agregado exitosamente");
        return postResponseDto;
    }

    @Override
    public ResponseDto post(PromoPostRequestDto postPromo) {

        getUserDto(postPromo.getUserId());

        List<PromoPostResponseDto> posts = this._postRepository.getAll()
                                                           .stream()
                                                           .filter(post1 -> post1.getUserId() == postPromo.getUserId()
                                                                         && post1.getDate().equals(postPromo.getDate())
                                                                         && post1.getProduct().getProductId() == postPromo.getProduct().getProductId())
                                                           .map(post1 -> modelMapper.map(postPromo, PromoPostResponseDto.class))
                                                           .toList();

        if (!posts.isEmpty()) throw new PostAlreadyExist("Ya existe un promo-post para este producto");
        this._postRepository.post(modelMapper.map(postPromo, Post.class));

        ResponseDto promoPostResponseDto = new ResponseDto();
        promoPostResponseDto.setMessage("Post promo agregado exitosamente");
        return promoPostResponseDto;
    }

    @Override
    public PromoPostCountProductsDto getPromoPostCountProducts(int userId) {

        PromoPostCountProductsDto promoPosts = new PromoPostCountProductsDto();
        User user = getUserDto(userId);

        promoPosts.setUserId(user.getUserId());
        promoPosts.setUserName(user.getUserName());
        promoPosts.setPromoProductsCount((int) _postRepository.getAll()
                                                              .stream()
                                                              .filter(postPromo -> postPromo.isHasPromo() == true && postPromo.getUserId() == userId)
                                                              .count());
        return promoPosts;


    }

    @Override
    public List<PostResponseDto> getAll() {
        return this._postRepository.getAll()
                               .stream()
                               .map(post -> modelMapper.map(post, PostResponseDto.class))
                               .toList();
    }

    // metodo sobrecargado para prueba
    public SellerFollowedListPostResponseDto sellerFollowedListPosts(int userId, String order) {
//      Se define el tiempo de publicacion de posts de las ultimas dos semanas
//      Se define una fecha limite/base de dos semanas hacia atras desde la fecha actual
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        System.out.println("HOLA" + twoWeeksAgo);
        if (this._postRepository.getSellerFollowed(userId).isEmpty())
            throw new EmptySellerFollowedList("Los vendedores que sigues no tienen publicaciones");
        List<PostResponseDto> posts = this._postRepository.getSellerFollowed(userId).stream()
                .filter(post -> {
                    LocalDate postDate = post.getDate();
//                  Se filtran los posts que tengan una fecha de publicacion mayor o igual a dos semanas
                    return postDate.isAfter(twoWeeksAgo) || postDate.isEqual(twoWeeksAgo);
                })
//              Se mapea la lista de posts a una lista de PostResponseDto
                .map(post -> modelMapper.map(post, PostResponseDto.class))
//              Se ordena la lista de posts por fecha de publicacion
                .sorted((post1, post2) -> {
                    LocalDate date1 = post1.getDate();
                    LocalDate date2 = post2.getDate();

//                  Se ordena la lista de posts por fecha de publicacion de forma ascendente o descendente
                    if ("date_asc".equals(order)) {
                        return date1.compareTo(date2);
                    } else if ("date_desc".equals(order)) {
                        return date2.compareTo(date1);
                    } else {
                        return 0;
                    }
                })
//               Se convierte la lista a un ArrayList
                .collect(Collectors.toList());
//        System.out.println("HOLA" + posts.size());
        if (posts.isEmpty())
            throw new EmptySellerFollowedList("Los vendedores que sigues no han hecho publiciones en las últimas dos semanas");
        return new SellerFollowedListPostResponseDto(userId, posts);

    }

    private User getUserDto(int userId){

        User user = _userRepository.findUserById(userId);

        if (user == null) {
            throw new UserNotFoundException("Usuario no encontrado.");
        }
        return user;
    }
}
