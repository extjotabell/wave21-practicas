package com.segurodeautos.service;

import com.segurodeautos.dto.request.AccidentDTO;
import com.segurodeautos.dto.request.CarDTO;
import com.segurodeautos.dto.response.MessageDTO;
import com.segurodeautos.model.Accident;
import com.segurodeautos.model.Car;
import com.segurodeautos.repository.AccidentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccidentService {

    private final ModelMapper modelMapper;
    private final AccidentRepository accidentRepository;

    public AccidentService(ModelMapper modelMapper, AccidentRepository accidentRepository){
        this.modelMapper = modelMapper;
        this.accidentRepository = accidentRepository;
    }

    public MessageDTO createAccident(AccidentDTO accidentDTO){
        Accident response = accidentRepository.save(modelMapper.map(accidentDTO, Accident.class));
        return new MessageDTO(String.format("Accidente creado con el id %s", response.getId()));
    }
}
