package com.example.linktracker.service.impl;

import com.example.linktracker.dto.LinkDto;
import com.example.linktracker.dto.MetricsDTO;
import com.example.linktracker.exception.InvalidLinkException;
import com.example.linktracker.model.Link;
import com.example.linktracker.repository.interfaces.ILinkRepository;
import com.example.linktracker.service.LinkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {
    private ILinkRepository repository;
    private ModelMapper modelMapper;

    public LinkServiceImpl(ILinkRepository repository, ModelMapper modelMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LinkDto getLinkById(Long id) {
        Link linkFound = repository.getLinkById(id).orElse(null);

        if(linkFound==null)
            throw new InvalidLinkException("No existe ningun link con el id: "+id);

        return modelMapper.map(linkFound, LinkDto.class);
    }

    @Override
    public void invalidateLink(Long id) {
        repository.invalidateLink(id);
    }


    @Override
    public MetricsDTO getMetrics(Long id){
        Integer redirects = repository.getMetrics(id);
        if(redirects == null){
            throw new InvalidLinkException("No se pudo encontrar un link con el id " + id);
        }
        MetricsDTO metrics = new MetricsDTO(redirects);
        return metrics;
    }

    @Override
    public LinkDto addLink(String link, String password) {
        return modelMapper.map(repository.addLink(link,password), LinkDto.class);
    }

}
