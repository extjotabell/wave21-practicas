package com.empleadosproductospg.service;

import com.empleadosproductospg.model.dto.EmpleadoDTO;
import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDTO> getAllEmpleados();
    EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO);
    EmpleadoDTO updateEmpleado(EmpleadoDTO empleadoDTO);
}
