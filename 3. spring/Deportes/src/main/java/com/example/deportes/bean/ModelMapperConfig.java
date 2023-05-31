package com.example.deportes.bean;

import com.example.deportes.clase.Sport;
import com.example.deportes.clase.SportPerson;
import com.example.deportes.dto.SportPersonDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(SportPerson.class, SportPersonDTO.class)
                .addMappings(
                        new PropertyMap<SportPerson, SportPersonDTO>() {
                            @Override
                            protected void configure() {
                                // define a converter that takes the whole "person"
                                using(ctx ->((SportPerson) ctx.getSource()).getPerson().getName() + " " + ((SportPerson) ctx.getSource()).getPerson().getLastName())
                                        // Map the compliete source here
                                        .map(source, destination.getName());

                                using(ctx -> ((SportPerson) ctx.getSource()).getSports().stream().map(Sport::getName).collect(Collectors.toList()))
                                        .map(source, destination.getSports());
                            }
                        });

        return modelMapper;
    }
}
