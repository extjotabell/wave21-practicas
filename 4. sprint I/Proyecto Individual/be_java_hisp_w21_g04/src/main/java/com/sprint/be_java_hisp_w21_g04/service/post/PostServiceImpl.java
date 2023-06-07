package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestPromoDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.EmptySellerFollowedList;
import com.sprint.be_java_hisp_w21_g04.exception.PostAlreadyExist;
import com.sprint.be_java_hisp_w21_g04.repository.post.IPostRepository;
import com.sprint.be_java_hisp_w21_g04.repository.post.PostRepositoryImpl;
import com.sprint.be_java_hisp_w21_g04.repository.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService{
    private IPostRepository _repository;
    private IUserRepository _userRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(IPostRepository repository,IUserRepository userRepository){
        this._repository = repository;
        this._userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public void post(PostRequestDto post) {
        List<PostResponseDto> posts = this._repository.getAll().stream().
                filter(post1 -> post1.getUserId() == post.getUserId() && post1.getDate().equals(post.getDate()) && post1.getProduct().getProductId() == post.getProduct().getProductId())
                .map(post1 -> modelMapper.map(post, PostResponseDto.class))
                .toList();
        if(!posts.isEmpty()) throw new PostAlreadyExist("Ya existe un post para este producto");
        this._repository.post(modelMapper.map(post, Post.class));
    }

    @Override
    public void promoPost(PostRequestPromoDto postPromo) {
        User user = _userRepository.getById(postPromo.getUserId());
        List<Post> posts = this._repository.getAllPromo().stream().toList();
        posts = posts.stream()
                    .filter(post -> post.getUserId() == postPromo.getUserId() &&
                            post.getDate().equals(postPromo.getDate()) &&
                            compareProducts(post.getProduct(), postPromo.getProduct()) &&
                            post.getCategory() == postPromo.getCategory() &&
                            Double.compare(post.getPrice(), postPromo.getPrice()) == 0 &&
                            post.isHasPromo() == postPromo.isHasPromo() &&
                            Double.compare(post.getDiscount(), postPromo.getDiscount()) == 0)
                    .collect(Collectors.toList());

        if(!posts.isEmpty()) throw new PostAlreadyExist("Ya existe este post");
        this._repository.postPromo(modelMapper.map(postPromo, Post.class));
    }

    @Override
    public PromoCountDto promoPostCount (int userId){
        User user = _userRepository.getById(userId);
        List<Post> posts = this._repository.getAllPromo().stream().
                filter(post -> post.getUserId() == userId )
                .toList();
        if(posts.isEmpty()) throw new PostAlreadyExist("El vendedor no tiene posts con promocion");
        return new PromoCountDto(user.getUserId(),user.getUserName(), posts.size());
    }
    @Override
    public PromoListDto promoList (int userId){
        User user = _userRepository.getById(userId);
        List<Post> posts = this._repository.getAllPromo().stream().
                filter(post -> post.getUserId() == userId )
                .toList();
        if(posts.isEmpty()) throw new PostAlreadyExist("El vendedor no tiene posts con promocion");
        return new PromoListDto(user.getUserId(),user.getUserName(),posts);
    }

    private boolean compareProducts(Product product1, Product product2) {
        return product1.getProductId() == product2.getProductId()
                && product1.getProductName().equals(product2.getProductName())
                && product1.getType().equals(product2.getType())
                && product1.getBrand().equals(product2.getBrand())
                && product1.getColor().equals(product2.getColor())
                && product1.getNotes().equals(product2.getNotes());
    }

    @Override
    public List<PostResponseDto> getAll() {
        return this._repository.getAll().stream().map(post -> modelMapper.map(post, PostResponseDto.class)).toList();
    }
    

//    metodo sobrecargado para prueba
    public SellerFollowedListPostResponseDto sellerFollowedListPosts(int userId, String order) {
//      Se define el tiempo de publicacion de posts de las ultimas dos semanas
//      Se define una fecha limite/base de dos semanas hacia atras desde la fecha actual
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        System.out.println("HOLA" + twoWeeksAgo);
        if(this._repository.getSellerFollowed(userId).isEmpty()) throw new EmptySellerFollowedList("Los vendedores que sigues no tienen publicaciones");
        List<PostResponseDto> posts = this._repository.getSellerFollowed(userId).stream()
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
        if(posts.isEmpty()) throw new EmptySellerFollowedList("Los vendedores que sigues no han hecho publiciones en las últimas dos semanas");
        return new SellerFollowedListPostResponseDto(userId, posts);

    }
}
