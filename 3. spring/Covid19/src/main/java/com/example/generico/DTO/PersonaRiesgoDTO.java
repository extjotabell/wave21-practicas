package com.example.generico.DTO;

import com.example.generico.entity.Sintoma;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public record PersonaRiesgoDTO (Integer personaId, List<Integer> sintomasId) { }
