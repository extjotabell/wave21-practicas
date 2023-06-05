package com.example.demo.service;

import com.example.demo.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

}
