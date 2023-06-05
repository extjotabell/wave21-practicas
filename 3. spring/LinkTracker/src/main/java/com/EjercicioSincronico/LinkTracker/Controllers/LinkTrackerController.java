package com.EjercicioSincronico.LinkTracker.Controllers;

import com.EjercicioSincronico.LinkTracker.DTOs.RequestDTO.RequestLinkDTO;
import com.EjercicioSincronico.LinkTracker.DTOs.ResponseDTO.ResponseLinkDTO;
import com.EjercicioSincronico.LinkTracker.Services.ILinkTrackerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/*
Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver un JSON con el
linkId para utilizar en la redirección.

Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect a la URL
enmascarada. Siempre y cuando el link sea válido. En el caso de que el link sea invalido devolver
404(INVESTIGAR REDIRECT).

Estadísticas por link: Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} ) tiene que
devolver la estadística de cantidad de veces que se redireccionó.

Invalidate link: Endpoint POST para invalidar un link (ej: http://localhost:8080/invalidate/{linkID} ).
Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a la
redirección.
*/

@RestController
public class LinkTrackerController {
    private ILinkTrackerService _linkTrackerService;

    public LinkTrackerController(ILinkTrackerService _linkTrackerService) {
        this._linkTrackerService = _linkTrackerService;
    }

    @GetMapping("/link/{linkId}")
    public  ResponseEntity<Void> redirectLinkById(@PathVariable int linkId, @RequestParam String urlPassword){
        ResponseLinkDTO resultLink =  _linkTrackerService.redirectLinkById(linkId, urlPassword);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(UriComponentsBuilder.fromUriString(resultLink.getUrl()).build().toUri());

        return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
    }

    @PostMapping("/link")
    public ResponseEntity<ResponseLinkDTO> insertLink(@RequestBody RequestLinkDTO requestLink){
        return ResponseEntity.status(HttpStatus.OK).body(_linkTrackerService.insertLink(requestLink));
    }
