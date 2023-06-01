package com.example.ejerciciopersonajesstarwarsenvivoypg.service;

import com.example.ejerciciopersonajesstarwarsenvivoypg.dto.ArtistResponseDTO;
import com.example.ejerciciopersonajesstarwarsenvivoypg.repository.IStarWarsRepository;
import com.example.ejerciciopersonajesstarwarsenvivoypg.repository.StarWarsRepository;
import com.example.ejerciciopersonajesstarwarsenvivoypg.utils.StarWarsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IStarWarsService{

    @Value("${not.found.artist}")
    private String NOT_FOUND_ARTIST;

    @Autowired
    IStarWarsRepository starWarsRepository;

    @Override
    public ResponseEntity<?> artistsByName(String name) {
        List<ArtistResponseDTO> result = StarWarsUtils.convertArtistsToDTO(starWarsRepository.getArtistsListByName(name));
        if(!result.isEmpty()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(NOT_FOUND_ARTIST, HttpStatus.NOT_FOUND);
    }
}