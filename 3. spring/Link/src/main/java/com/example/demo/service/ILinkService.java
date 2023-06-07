package com.example.demo.service;

import com.example.demo.dto.LinkDTOCreate;
import com.example.demo.dto.LinkDTORequest;
import com.example.demo.dto.LinkDTOId;
import com.example.demo.model.Link;
import org.springframework.http.ResponseEntity;

public interface ILinkService {
    LinkDTOId save(LinkDTOCreate linkDTO);
    String getById(LinkDTORequest linkdtorequest);
}
