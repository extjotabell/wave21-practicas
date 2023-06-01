package com.example.ejerciciopersonajesstarwarsenvivoypg.repository;

import com.example.ejerciciopersonajesstarwarsenvivoypg.entity.Artist;

import java.util.List;

public interface IStarWarsRepository {
    public List<Artist> getArtistsListByName(String name);
}
