package com.linkTracker.linkTracker.service;

import com.linkTracker.linkTracker.dto.ContadorDTO;
import com.linkTracker.linkTracker.dto.LinkDTO;
import com.linkTracker.linkTracker.dto.ResponseDTO;
import com.linkTracker.linkTracker.exception.LinkNotFoundException;
import com.linkTracker.linkTracker.exception.UnauthorizedException;
import com.linkTracker.linkTracker.model.Link;
import com.linkTracker.linkTracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkService {
    @Autowired
    LinkRepository repository;

    public ResponseDTO save(String contrasena, LinkDTO dto){
        Link model = new Link(dto.getUrl(), (int) (Math.random()*25+1),contrasena );
        ResponseDTO result = new ResponseDTO();
        if (repository.saveLink(model)){
            result.setLinkId(model.getId());
        }
        return result;
    }

    public RedirectView redirectToLink(String contrasena, int linkId){
        Link result = repository.findById(linkId);
        if( result == null){
            throw new LinkNotFoundException("Id invalido");
        }
        if (!contrasena.equals(result.getContrasena())) {
            throw new UnauthorizedException("Contraseña incorrecta. Vuelva a intentar");
        }
            LinkDTO linkFromClient = new LinkDTO(result.getUrl(), linkId);
            RedirectView urlToRedirect = new RedirectView();
            urlToRedirect.setUrl(linkFromClient.getUrl());
            repository.sumarContador(linkId);
            return urlToRedirect;
    }

    public void delete (int linkId){
        if(repository.findById(linkId) == null){
            throw new LinkNotFoundException("No se encontró el id para invalidar");
        }
        repository.delete(linkId);
    }

    public ContadorDTO contarRedirecciones(int linkId){
        Link linkEncontrado = repository.findById(linkId);
        if( linkEncontrado == null){
            throw new LinkNotFoundException("No se encontró el id para contar");
        }
        return new ContadorDTO(linkEncontrado.getContadorRedireccion());
    }

}
