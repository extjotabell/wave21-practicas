package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.ListMarcaModeloVehiculoDTO;
import com.bootcamp.autos.dto.ListVehiculoDTO;
import com.bootcamp.autos.dto.VehiculoDTO;
import com.bootcamp.autos.entity.Vehiculo;
import com.bootcamp.autos.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImp implements IVehiculoService{

    private IVehiculoRepository vehiculoRepository;
    private ModelMapper mapper;
    public VehiculoServiceImp(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public VehiculoDTO saveCar(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = mapper.map(vehiculoDTO, Vehiculo.class);
        VehiculoDTO response = mapper.map(vehiculoRepository.save(vehiculo));
        return response;
    }

    @Override
    public ListVehiculoDTO findAll() {

        return new ListVehiculoDTO(vehiculoRepository.findAll()
                                                     .stream()
                                                     .map(m-> mapper.map(m,VehiculoDTO.class))
                                                     .toList());
    }

    @Override
    public VehiculoDTO findById() {
        return null;
    }

    @Override
    public VehiculoDTO deleteCar(Long id) {
        return null;
    }

    @Override
    public List<String> findByPatente() {
        return null;
    }

    @Override
    public List<ListMarcaModeloVehiculoDTO> findPatenteAndMarceOrderByAnioFabricacion() {
        return null;
    }
}
