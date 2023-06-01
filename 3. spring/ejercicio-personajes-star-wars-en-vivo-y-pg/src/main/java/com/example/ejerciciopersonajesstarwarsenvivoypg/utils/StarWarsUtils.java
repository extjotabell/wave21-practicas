package com.example.ejerciciopersonajesstarwarsenvivoypg.utils;

import com.example.ejerciciopersonajesstarwarsenvivoypg.dto.ArtistResponseDTO;
import com.example.ejerciciopersonajesstarwarsenvivoypg.entity.Artist;
import org.springframework.ui.ModelMap;

import java.util.List;

public class StarWarsUtils {
    public static List<ArtistResponseDTO> convertArtistsToDTO(List<Artist> artists){

        ModelMap mapper = new ModelMap();
        return artists.stream()
                .map(artist -> {
                    mapper.map()
                    ArtistResponseDTO artistDTO = new ArtistResponseDTO();
                    artistDTO.setMass(artist.getMass());
                    artistDTO.setName(artist.getName());
                    artistDTO.setGender(artist.getGender());
                    artistDTO.setHeight(artist.getHeight());
                    artistDTO.setSpecies(artist.getSpecies());
                    artistDTO.setHomeworld(artist.getHomeworld());
                    return artistDTO;
                }).toList();
    }
}
