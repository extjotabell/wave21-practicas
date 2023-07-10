package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.SiniestroDTO;
import com.bootcamp.autos.entity.Siniestro;
import com.bootcamp.autos.entity.Vehiculo;
import com.bootcamp.autos.exception.SiniestroNotFoundException;
import com.bootcamp.autos.exception.VehiculoNotFoundException;
import com.bootcamp.autos.repository.ISiniestroRepository;
import com.bootcamp.autos.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SiniestroServiceImp implements ISiniestroService{

    private ISiniestroRepository siniestroRepository;
    private IVehiculoRepository vehiculoRepository;
    private ModelMapper mapper ;

    public SiniestroServiceImp(ISiniestroRepository siniestroRepository, IVehiculoRepository vehiculoRepository) {
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public SiniestroDTO saveSiniestro(Long id, SiniestroDTO siniestroDTO) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(()->new VehiculoNotFoundException("Vehiculo No encontrado"));
        Siniestro siniestro = mapper.map(siniestroDTO, Siniestro.class);
        siniestro.setVehiculo(vehiculo);
        SiniestroDTO response = mapper.map(siniestroRepository.save(siniestro),SiniestroDTO.class);
        response.setMessage("Siniestro Guardado con exito");
        return response;
    }

    @Override
    public List<SiniestroDTO> findAll() {
        return siniestroRepository.findAll().stream()
                                            .map(m->mapper.map(m,SiniestroDTO.class))

                                            .toList();
    }

    @Override
    public SiniestroDTO findByID(Long id) {
        return null;
    }

    @Override
    public SiniestroDTO deleteSiniestro(Long idVehiculo, Long idSiniestro) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo).orElseThrow(()->new VehiculoNotFoundException("vehiculo no encontrado"));
        vehiculo.getSiniestros().stream().filter(g->g.getId() == idSiniestro).findFirst().orElseThrow(()->new SiniestroNotFoundException("No se encontro el siniestro seleccionado"));
        Siniestro siniestroToDelete = siniestroRepository.findById(idSiniestro).orElseThrow(()->new SiniestroNotFoundException("No se encontro el siniestro seleccionado"));

        vehiculo.getSiniestros().remove(siniestroToDelete);
        siniestroRepository.delete(siniestroToDelete);
        SiniestroDTO response = mapper.map(siniestroToDelete, SiniestroDTO.class);
        response.setMessage("Se ha eliminado el siniestro correctamente");
        return response;
    }
}
