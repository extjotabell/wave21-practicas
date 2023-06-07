package com.bootcamp.grupo3.socialmeli.config;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.model.Post;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Post.class, PostDTO.class)
            .addMappings(new PropertyMap<Post, PostDTO>() {
                protected void configure() {
                    this.using((ctx) -> ((Post)ctx.getSource()).getLikes().size())
                            .map(this.source, this.destination.getLikes());
                }
            });

        return modelMapper;
    }
}
