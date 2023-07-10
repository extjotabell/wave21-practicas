package com.example.lasPerlasJoyeria.service;

import com.example.lasPerlasJoyeria.dto.JewelDTO;
import com.example.lasPerlasJoyeria.model.Jewel;
import com.example.lasPerlasJoyeria.repository.IJewerlyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewerlyService implements IJewerlyService {


    private  IJewerlyRepository jewerlyRepo;
    private  ModelMapper mapper;

    public JewerlyService(IJewerlyRepository jewerlyRepo ){
        this.mapper = new ModelMapper();
        this.jewerlyRepo = jewerlyRepo;
    }


    @Override
    public List<JewelDTO> getJewelryList() {

        return null;
    }

    @Override
    public void saveJewel(JewelDTO jewel) {

    }

    @Override
    public void deleteJewel(long id) {

    }

    @Override
    public JewelDTO findJewel(long id) {
        return null;
    }
}
