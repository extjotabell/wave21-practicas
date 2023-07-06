package com.ejerciciopracticoindividual.joyeria.service.impl;

import com.ejerciciopracticoindividual.joyeria.dto.JoyaDTO;
import com.ejerciciopracticoindividual.joyeria.model.Joya;
import com.ejerciciopracticoindividual.joyeria.repository.IJoyaRepository;
import com.ejerciciopracticoindividual.joyeria.service.JoyaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements JoyaService {

    private IJoyaRepository joyaRepository;

    private ModelMapper modelMapper;

    public JoyaServiceImpl(IJoyaRepository joyaRepository,ModelMapper modelMapper){
        this.joyaRepository=joyaRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public String guardar(JoyaDTO joyaDTO) {
        return "La joya ha sido creada correctamente con el id: "+joyaRepository.save(modelMapper.map(joyaDTO, Joya.class)).getId();
    }

    @Override
    public JoyaDTO guardar(Integer id, JoyaDTO joyaDTO) {
        Joya joyaResponse = joyaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("El id no es valido."));

        joyaDTO.setId(joyaResponse.getId());

        return modelMapper.map(joyaRepository.save(modelMapper.map(joyaDTO,Joya.class)),JoyaDTO.class);
    }

    @Override
    public List<JoyaDTO> listar() {
        return joyaRepository.findAll().stream().filter(joya -> joya.getVentaONo()==true).map(joya -> modelMapper.map(joya,JoyaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void borrar(Integer id) {
        Joya joyaABorrar = joyaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El id es inválido"));
        joyaABorrar.setVentaONo(false);
        joyaRepository.save(joyaABorrar);
    }
}
