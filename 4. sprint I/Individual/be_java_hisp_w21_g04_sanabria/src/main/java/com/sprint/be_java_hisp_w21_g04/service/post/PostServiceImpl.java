package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostProductOnSaleRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.EmptySellerFollowedList;
import com.sprint.be_java_hisp_w21_g04.exception.NotFoundException;
import com.sprint.be_java_hisp_w21_g04.exception.PostAlreadyExist;
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
    public void post(PostRequestDto post) {
        List<PostResponseDto> posts = this._repository.getAll().stream().
                filter(post1 -> post1.getUserId() == post.getUserId() && post1.getDate().equals(post.getDate()) && post1.getProduct().getProductId() == post.getProduct().getProductId())
                .map(post1 -> modelMapper.map(post, PostResponseDto.class))
                .toList();
        if(!posts.isEmpty()) throw new PostAlreadyExist("Ya existe un post para este producto");
        this._repository.post(modelMapper.map(post, Post.class));
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

    @Override
    public ResponseDto postProductOnSale(PostProductOnSaleRequestDto post) {
        if(!post.isHasPromo() || post.getDiscount()<=0d) throw new IllegalArgumentException("El post debe tener descuento");
        if(this._userRepository.getById(post.getUserId())!=null){
            List<ProductOnSaleResponseDto> posts = this._repository.getAll().stream().
                    filter(post1 -> post1.getUserId() == post.getUserId() && post1.getDate().equals(post.getDate()) && post1.getProduct().getProductId() == post.getProduct().getProductId())
                    .map(post1 -> modelMapper.map(post, ProductOnSaleResponseDto.class))
                    .toList();
            if (!posts.isEmpty()) throw new PostAlreadyExist("Ya existe un post para este producto");
            this._repository.post(modelMapper.map(post, Post.class));
            return new ResponseDto("Post con descuento creado con exito");
        }
        throw new NotFoundException("El usuario no existe");
    }

    @Override
    public PostProductOnSaleCountDto countPromoPost(int userId) {
        User user = this._userRepository.getById(userId);
        int count = this._repository.getAll().stream().filter(post -> post.getUserId() == userId && post.isHasPromo()).toList().size();
        PostProductOnSaleCountDto postProductOnSaleCountDto = new PostProductOnSaleCountDto(userId,user.getUserName(), count);
        return modelMapper.map(postProductOnSaleCountDto, PostProductOnSaleCountDto.class);
    }

    @Override
    public ListProductsOnSaleResponseDto listProductsOnSaleSorted(int userId, String order) {
        User user = this._userRepository.getById(userId);
        if(user==null) throw new NotFoundException("El usuario no existe");
        List<ProductOnSaleResponseDto> listSorted = this._repository.getAll().stream().filter(post -> post.getUserId() == userId && post.isHasPromo())
                .map(post -> modelMapper.map(post, ProductOnSaleResponseDto.class))
                .sorted((post1, post2) -> {
                    System.out.println(post1.getProduct().getProductName());
                    String name1 = post1.getProduct().getProductName();
                    String name2 = post2.getProduct().getProductName();
                    if ("name_asc".equals(order)) {
                        return post1.getProduct().getProductName().compareTo(name2);
                    } else{
                        return name2.compareTo(name1);
                    }
                })
                .toList();

        if (listSorted.isEmpty()) throw new NotFoundException("No hay productos con descuento para el usuario "+userId);
        return  new ListProductsOnSaleResponseDto(userId,user.getUserName(),listSorted);
    }
}
