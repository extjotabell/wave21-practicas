package com.example.LinkTracker.repository;

import com.example.LinkTracker.entity.Link;
import com.example.LinkTracker.exception.LinkNotFoundException;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class LinkRepository {
    List<Link> links;

    public List<Link> getAll(){
        return this.links;
    }

    public void addNumberOfRedirects(final Integer id) {
        var link = this.links
                .stream()
                .filter(l -> l.getLinkId() == id)
                .findFirst()
                .orElseThrow();

        link.setNumberOfRedirects(link.getNumberOfRedirects()+1);
    }

    public Optional<Link> getLinkById(final int id){

        return this.links
                .stream()
                .filter(n->n.getLinkId() == id)
                .findFirst();
    }

    public Integer create(Link link){
        link.setLinkId(links.size()+1);
        this.links.add(link);
        return link.getLinkId();
    }

    public void invalidateLink(final int id){
        Link link = this.getLinkById(id).orElseThrow(()-> new LinkNotFoundException("No se encontro el link a invalidar"));
        link.setEstado(Link.Estado.INVALIDO);
    }

}
