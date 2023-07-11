package com.obrasliterarias.service;

import com.obrasliterarias.model.dto.ObraDTO;
import com.obrasliterarias.model.entity.Obra;
import com.obrasliterarias.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObraService implements IObraService{

    private IObraRepository repository;
    private ModelMapper mapper;

    public ObraService(IObraRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ObraDTO> getAllObras() {
        List<ObraDTO> result = new ArrayList<>();
        repository.findAll().forEach(obra -> {
            result.add(mapper.map(obra, ObraDTO.class));
        });
        return result;
    }

    @Override
    public ObraDTO createObra(ObraDTO obraDTO) {
        Obra response = repository.save(mapper.map(obraDTO, Obra.class));
        return mapper.map(response,ObraDTO.class);
    }

    @Override
    public List<ObraDTO> autorParam(String autor) {
        return repository.findByAutor(autor).stream().map(obra ->
                mapper.map(obra, ObraDTO.class)).toList();
    }

    @Override
    public List<ObraDTO> containsTitle(String title) {
        return repository.findByNombreContaining(title).stream().map(obra ->
                mapper.map(obra, ObraDTO.class)).toList();
    }

    @Override
    public List<ObraDTO> obrasPagesGreaterThanParam(Integer cantidad) {
        return repository.findByCantidadPaginasGreaterThan(cantidad).stream().map(obra ->
                mapper.map(obra, ObraDTO.class)).toList();
    }

    @Override
    public List<ObraDTO> obrasYearGreaterThanParam(Integer year) {
        return repository.findByYearGreaterThanEqual(year).stream().map(obra ->
                mapper.map(obra, ObraDTO.class)).toList();
    }

    @Override
    public List<ObraDTO> obrasYearLowerThanParam(Integer year) {
        return repository.findByYearLessThanEqual(year).stream().map(obra ->
                mapper.map(obra, ObraDTO.class)).toList();
    }

    @Override
    public List<ObraDTO> obrasSameEditorialThanParam(String editorial) {
        return repository.findByEditorialEquals(editorial).stream().map(obra ->
                mapper.map(obra, ObraDTO.class)).toList();
    }
}
