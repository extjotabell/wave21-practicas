package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.dto.LinkIdDTO;
import com.example.LinkTracker.dto.LinkRedirectsDTO;
import com.example.LinkTracker.entity.Link;
import com.example.LinkTracker.exception.InvalidURLException;
import com.example.LinkTracker.exception.LinkNotFoundException;
import com.example.LinkTracker.exception.NoMetricUpdateException;
import com.example.LinkTracker.exception.PasswordException;
import com.example.LinkTracker.repository.LinkRepository;
import com.example.LinkTracker.util.Mapper;
import com.example.LinkTracker.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.NoSuchElementException;
import java.util.stream.Stream;

@Service
public class LinkService {

    @Autowired
    LinkRepository linkRepository;

    public String getLink(int id, String password) {
        Link link = this.linkRepository.getLinkById(id) // caso feliz
                .orElseThrow(() -> new LinkNotFoundException("Link no encontrado"));
                // ---> caso triste basicamente es lo que pones en el else de lo que estes validando <---- juanma
        //Joyaaa

        if (link.getPassword().equals(password)) {
            if (link.getEstado().equals(Link.Estado.VALIDO)) {
                return link.getUrl();
            } else {
                throw new PasswordException("Password Invalida");
            }
        }
    }

        public LinkRedirectsDTO getMetrics ( final Integer id) throws LinkNotFoundException {
            return linkRepository.getLinkById(id)
                    .map(Mapper::linktoLinkRedirectsDTO)
                    .orElseThrow(() -> new LinkNotFoundException("no se encontro el link"));
        }

        public void countRedirects ( final Integer id){
            try {
                linkRepository.addNumberOfRedirects(id);
            } catch (NoSuchElementException e) {
                throw new NoMetricUpdateException("No se pudo contabilizar la estadistica");
            }

        }

        public LinkIdDTO createLink (LinkDTO linkDTO){

            if (Validator.validateUrl(linkDTO.getUrl()))
                throw new InvalidURLException("La url no es valida");

            Link link = new Link();

            link.setUrl(linkDTO.getUrl());
            link.setPassword(linkDTO.getPassword());
            link.setEstado(Link.Estado.VALIDO);

            LinkIdDTO linkIdDTO = new LinkIdDTO(linkRepository.create(link));

            return linkIdDTO;
        }


    public LinkIdDTO invalidateLink(Integer linkID) {
        linkRepository.invalidateLink(linkID);
        return new LinkIdDTO(linkID);
    }
}