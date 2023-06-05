package com.EjercicioSincronico.LinkTracker.Services;

import com.EjercicioSincronico.LinkTracker.DTOs.RequestDTO.RequestLinkDTO;
import com.EjercicioSincronico.LinkTracker.DTOs.ResponseDTO.ResponseLinkDTO;

public interface ILinkTrackerService {
    ResponseLinkDTO redirectLinkById(int linkId, String urlPassword);

    ResponseLinkDTO insertLink(RequestLinkDTO requestLink);
}
