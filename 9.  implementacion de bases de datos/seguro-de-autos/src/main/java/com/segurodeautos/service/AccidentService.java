package com.segurodeautos.service;

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
}
