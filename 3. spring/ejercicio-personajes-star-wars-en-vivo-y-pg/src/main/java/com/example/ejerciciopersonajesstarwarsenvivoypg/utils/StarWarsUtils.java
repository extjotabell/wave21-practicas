package com.example.ejerciciopersonajesstarwarsenvivoypg.utils;

import com.example.ejerciciopersonajesstarwarsenvivoypg.dto.ArtistResponseDTO;
import com.example.ejerciciopersonajesstarwarsenvivoypg.entity.Artist;
import org.springframework.ui.ModelMap;

import java.util.List;

public class StarWarsUtils {
    public static List<ArtistResponseDTO> convertArtistsToDTO(List<Artist> artists){
        return artists.stream()
                .map(artist -> {
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
