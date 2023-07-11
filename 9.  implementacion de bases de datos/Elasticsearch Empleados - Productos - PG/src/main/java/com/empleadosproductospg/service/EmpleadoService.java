package com.empleadosproductospg.service;

import com.empleadosproductospg.model.dto.EmpleadoDTO;
import com.empleadosproductospg.model.entity.Empleado;
import com.empleadosproductospg.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

    private IEmpleadoRepository repository;
    private ModelMapper mapper;

    public EmpleadoService(IEmpleadoRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<EmpleadoDTO> getAllEmpleados() {
        List<EmpleadoDTO> result = new ArrayList<>();
        repository.findAll().forEach(empleado -> {
            result.add(mapper.map(empleado, EmpleadoDTO.class));
        });
        return result;
    }

    @Override
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO) {
        return saveEmpleado(empleadoDTO);
    }

    @Override
    public EmpleadoDTO updateEmpleado(EmpleadoDTO empleadoDTO) {
        List<EmpleadoDTO> filteredList = this.getAllEmpleados().stream().filter(empleadoDTO1 -> empleadoDTO1.getId()
                .equals(empleadoDTO.getId())).toList();
        if(filteredList.isEmpty()){
            throw new RuntimeException("Empleado no encontrado");
        }
        return saveEmpleado(empleadoDTO);
    }

    private EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO){
        Empleado response = repository.save(mapper.map(empleadoDTO, Empleado.class));
        return mapper.map(response,EmpleadoDTO.class);
    }
}
