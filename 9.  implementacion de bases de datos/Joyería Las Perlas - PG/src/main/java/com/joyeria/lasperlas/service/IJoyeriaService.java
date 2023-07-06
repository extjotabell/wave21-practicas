package com.joyeria.lasperlas.service;

import com.joyeria.lasperlas.model.Joya;

import java.util.List;

public interface IJoyeriaService {
    public List<Joya> getJoyas ();
    public Joya saveJoya (Joya joya);
    public void deleteJoya (long id);
    public Joya findJoya (long id);
}
