package com.example.covid.bean;

import com.example.covid.clases.Person;
import com.example.covid.clases.PersonSymptoms;
import com.example.covid.dto.PersonSymptomsDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(PersonSymptoms.class, PersonSymptomsDTO.class)
                .addMappings(
                        new PropertyMap<PersonSymptoms, PersonSymptomsDTO>() {
                            @Override
                            protected void configure() {
                                // define a converter that takes the whole "person"
                                using(ctx -> ((PersonSymptoms) ctx.getSource()).getPerson().getName() + " " + ((PersonSymptoms) ctx.getSource()).getPerson().getLastName())
                                        // Map the compliete source here
                                        .map(source, destination.getName());
                                using(ctx -> ((PersonSymptoms) ctx.getSource()).getPerson().getAge())
                                        .map(source, destination.getAge());
                            }
                        });
        return modelMapper;
    }

}
