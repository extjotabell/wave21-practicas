package com.JPA.demo.service;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.service.interfaces.IPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {


    ModelMapper mapper = new ModelMapper();

    @Override
    public PersonDTO saveEntity(PersonDTO personDTO) {
        return null;
    }



    @Override
    public PersonDTO getEntityById(Integer id) {
        return null;
    }

    @Override
    public List<PersonDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer id) {
        return null;
    }
}
