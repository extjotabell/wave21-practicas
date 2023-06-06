package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.repository.post.IPostRepository;
import com.sprint.be_java_hisp_w21_g04.repository.post.PostRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService{
    private IPostRepository _repository;
    private ModelMapper modelMapper;

    public PostServiceImpl(IPostRepository repository){
        this._repository = repository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public void post(PostRequestDto post) {
        this._repository.post(modelMapper.map(post, Post.class));
    }

    @Override
    public List<PostResponseDto> getAll() {
        return this._repository.getAll().stream().map(post -> modelMapper.map(post, PostResponseDto.class)).toList();
    }
    

//    metodo sobrecargado para prueba
    @Override
    public SellerFollowedListPostResponseDto sellerFollowedListPosts(int user_id, String order) {

//      Se ordena la lista de posts segun el parametro 'order'
        List<PostResponseDto> posts = this._repository.getSellerFollowed(user_id).stream()
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
//                  Se convierte la lista a un ArrayList
                    .collect(Collectors.toList());

//        System.out.println("HOLA" + posts.size());
        return new SellerFollowedListPostResponseDto(user_id, posts);
    }
}
