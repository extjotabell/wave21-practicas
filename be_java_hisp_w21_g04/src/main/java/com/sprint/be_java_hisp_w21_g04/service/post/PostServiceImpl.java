package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.EmptySellerFollowedList;
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
    public void post(PostRequestDto post) {
        User user = this._userRepository.getById(post.getUserId());
        if(user==null) throw new UserNotFoundException("El usuario no existe");
        this._repository.post(modelMapper.map(post, Post.class));
    }

    @Override
    public List<PostResponseDto> getAll() {
        return this._repository.getAll().stream().map(post -> modelMapper.map(post, PostResponseDto.class)).toList();
    }
    
    public SellerFollowedListPostResponseDto sellerFollowedListPosts(int userId, String order) {

        User user = this._userRepository.getById(userId);
        if(user==null) throw new UserNotFoundException("El usuario no existe");
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        if(this._repository.getSellerFollowed(userId).isEmpty()) throw new EmptySellerFollowedList("Los vendedores que sigues no tienen publicaciones");
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
        if(posts.isEmpty()) throw new EmptySellerFollowedList("Los vendedores que sigues no han hecho publiciones en las últimas dos semanas");
        return new SellerFollowedListPostResponseDto(userId, posts);

    }
}
