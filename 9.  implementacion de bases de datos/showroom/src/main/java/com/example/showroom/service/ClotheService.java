package com.example.showroom.service;

import com.example.showroom.model.entity.Clothe;
import com.example.showroom.repository.ClotheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClotheService implements IClotheService {
    private final ClotheRepository clotheRepository;

    public ClotheService(ClotheRepository clotheRepository) {
        this.clotheRepository = clotheRepository;
    }

    public Clothe save(Clothe clothe) {
        return clotheRepository.save(clothe);
    }

    public List<Clothe> findAll() {
        return clotheRepository.findAll();
    }

    @Override
    public Clothe findById(Integer id) {
        return clotheRepository.findById(id).orElse(null);
    }

    @Override
    public Clothe updateById(Integer id, Clothe clothe) {
        Clothe clotheToUpdate = clotheRepository.findById(id).orElse(null);
        clotheToUpdate.setName(clothe.getName());
        clotheToUpdate.setColor(clothe.getColor());
        clotheToUpdate.setSize(clothe.getSize());
        clotheToUpdate.setPrice(clothe.getPrice());
        return clotheRepository.save(clotheToUpdate);
    }

    @Override
    public void deleteById(Integer id) {
        clotheRepository.deleteById(id);
    }

    @Override
    public List<Clothe> findBySize(String size) {
        return clotheRepository.findAllBySize(size);
    }

    @Override
    public List<Clothe> findByName(String name) {
        return clotheRepository.findAllByNameContainingIgnoreCase(name);
    }
}
