package com.EjercicioSincronico.LinkTracker.Services;

import com.EjercicioSincronico.LinkTracker.DTOs.RequestDTO.RequestLinkDTO;
import com.EjercicioSincronico.LinkTracker.DTOs.ResponseDTO.ResponseLinkDTO;
import com.EjercicioSincronico.LinkTracker.Entities.Link;
import com.EjercicioSincronico.LinkTracker.Exceptions.InvalidLinkStatusException;
import com.EjercicioSincronico.LinkTracker.Exceptions.InvalidPasswordException;
import com.EjercicioSincronico.LinkTracker.Exceptions.NotFoundLinkException;
import com.EjercicioSincronico.LinkTracker.Repository.ILinkTrackerRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinktrackerServiceImpl implements ILinkTrackerService{
    private static final String URL_REGEX = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
    private ILinkTrackerRepository _linkRepository;

    public LinktrackerServiceImpl(ILinkTrackerRepository _linkRepository) {
        this._linkRepository = _linkRepository;
    }

    @Override
    public ResponseLinkDTO redirectLinkById(int linkId, String urlPassword) {
        // Obtener el link, si existe o no
        Link linkPersisted = _linkRepository.getLinkbyId(linkId);
        if (linkPersisted == null){
            // Ejecutar Exception de que el Link no existe.
            throw new NotFoundLinkException("El Link solicitado no se ha encontrado");
        }

        if (linkPersisted.getPassword() != urlPassword) {
            // Ejecutar Exception que la contraseña no coincide
            throw new InvalidPasswordException("La contraseña ingresada no es valida");
        }

        if (!linkPersisted.isStatus()){
            // Ejecutar Exception que el link no es valido STATUS = FALSE;
            throw new InvalidLinkStatusException("El Link se encuentra deshabilitado");
        }
        // Si existe un link, actualiza metrica.
        _linkRepository.updateMetrics(linkPersisted.getId());

        return new ResponseLinkDTO(linkPersisted.getId(), linkPersisted.getUrl());

    }

    @Override
    public ResponseLinkDTO insertLink(RequestLinkDTO requestLink) {
        try {
            Link newLink = new Link();
            if(isValidUrl(requestLink.getUrl()){

            }

        }
        return null;
    }


    private boolean isValidUrl(String url) {
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();

    }
}
