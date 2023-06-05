package com.example.LinkTracker.util;

import com.example.LinkTracker.dto.LinkRedirectsDTO;
import com.example.LinkTracker.entity.Link;
import com.example.LinkTracker.repository.LinkRepository;

public class Mapper {
    public static LinkRedirectsDTO linktoLinkRedirectsDTO(Link l) {
        return new LinkRedirectsDTO(l.getNumberOfRedirects());
    }
}
