package com.sprint.be_java_hisp_w21_g04.service.post;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.repository.post.IPostRepository;
import com.sprint.be_java_hisp_w21_g04.repository.post.PostRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public SellerFollowedListPostResponseDto sellerFollowedListPosts(int user_id) {
        List<PostResponseDto> posts = this._repository.getSellerFollowed(user_id).stream()
                .map(post -> modelMapper.map(post, PostResponseDto.class)).toList();
        return new SellerFollowedListPostResponseDto(user_id, posts);
    }
}
