package com.example.demo.services;

import com.example.demo.domain.ObraLiteraria;
import com.example.demo.elasticrepositories.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaServiceImp implements ObraLiterariaService{

    @Autowired
    private ObraLiterariaRepository obraLiterariaRepository;

    @Override
    public ObraLiteraria save(ObraLiteraria obraLiteraria) {
        return obraLiterariaRepository.save(obraLiteraria);
    }

    public List<ObraLiteraria> findAll(){
        return obraLiterariaRepository.findAll();
    }

    public List<ObraLiteraria> getAllByAutor(String edad){
        return obraLiterariaRepository.findByAutor(edad);
    }

    /*
    public List<ObraLiteraria> getObraLiterariaByNombreAndOrder(String nombre, String orden){
        if(orden.toLowerCase().equals("asc"))
            return obraLiterariaRepository.findObraLiterariaByAutorStartingWith(nombre, Sort.by("nombre").ascending());
        else
            return obraLiterariaRepository.findObraLiterariaByAutorStartingWith(nombre, Sort.by("nombre").descending());
    }

     */
}
