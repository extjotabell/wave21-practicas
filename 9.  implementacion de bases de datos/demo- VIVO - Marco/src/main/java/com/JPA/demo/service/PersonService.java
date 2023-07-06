package com.JPA.demo.service;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.entity.Person;
import com.JPA.demo.repository.PersonRepository;
import com.JPA.demo.service.interfaces.IPersonService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    PersonRepository personRepository;
    ModelMapper mapper;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public PersonDTO saveEntity(PersonDTO personDTO) {
        Person person = mapper.map(personDTO, Person.class);

        personRepository.save(person);
        return mapper.map(person, PersonDTO.class);
    }

    @Override
    public PersonDTO getEntityById(Integer id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontramos lo que buscabas"));

        /*person.setSalary(person.getSalary() * 1.5);

        personRepository.save(person);*/

        return mapper.map(person, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllEntities() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(person -> mapper.map(person, PersonDTO.class))
                .toList();
    }

    @Override
    public MessageDTO deleteEntity(Integer id) {
        if(!personRepository.existsById(id)){
            throw new RuntimeException("No pudimos borrar las cosas");
        }
        personRepository.deleteById(id);
        return null;

    }
}
