package com.practicaJPA.joyeria.service.interfaces;

import com.practicaJPA.joyeria.dto.JoyaDTO;
import com.practicaJPA.joyeria.dto.MessageDTO;

import java.util.List;

public interface IJoyaService {

    JoyaDTO saveJoya(JoyaDTO joyaDTO) ;

    JoyaDTO getJoyayById(Integer id);

    List<JoyaDTO> getAllJoya();

    MessageDTO deleteJoya(Integer id);
}
