package com.example.demo.repository;

import com.example.demo.dto.LinkDTORequest;
import com.example.demo.model.Link;

public interface ILinkRepository {
    Link save(Link link);
    Link getById(LinkDTORequest linkdtorequest);
    Integer getId();
}
