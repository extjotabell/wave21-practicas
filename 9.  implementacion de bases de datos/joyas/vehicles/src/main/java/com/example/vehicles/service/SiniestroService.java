package com.example.vehicles.service;

import com.example.vehicles.entity.Siniestro;
import com.example.vehicles.repository.ISiniestroRepository;
import org.springframework.stereotype.Service;

@Service
public class SiniestroService {
        private final ISiniestroRepository iSiniestroRepository;
        
        public SiniestroService(ISiniestroRepository iSiniestroRepository){
                this.iSiniestroRepository = iSiniestroRepository;
        }

        public Object agregarSiniestro(Siniestro siniestro) {
               iSiniestroRepository.save(siniestro);
               return siniestro.toString();
        }

        public Object listarSiniestros(Integer idVehiculo) {
//               return iSiniestroRepository.findAll().stream().filter(siniestro -> siniestro.getIdVehiculoDenunciado().equals(idVehiculo)).toList();
                return null;
        }

        public Object listarSiniestro(Integer idSiniestro) {
                return null;
        }
}
