package com.seguros.seguros.controller;

import com.seguros.seguros.service.ISiniestroService;
import com.seguros.seguros.service.IVehiculoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculosController {
    ISiniestroService iSiniestroService;
    IVehiculoService iVehiculoService;

}
