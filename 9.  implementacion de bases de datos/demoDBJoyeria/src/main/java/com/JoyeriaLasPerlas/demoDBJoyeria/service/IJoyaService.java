package com.JoyeriaLasPerlas.demoDBJoyeria.service;

import com.JoyeriaLasPerlas.demoDBJoyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    public List<Joya> getJoya();
    public void saveJoya (Joya joya);
    public void deleteJoya (Integer id);
    public Joya findJoya (Integer id);

}
