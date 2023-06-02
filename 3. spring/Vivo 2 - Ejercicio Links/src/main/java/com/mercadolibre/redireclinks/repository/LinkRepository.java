package com.mercadolibre.redireclinks.repository;

import com.mercadolibre.redireclinks.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository {

    private Map<Integer, Link> links;
    private int id;

    public LinkRepository(){
        this.links = new HashMap<>();
        this.id = 1;
    }

    public void addLink(Link link){

        links.put(this.nextId(), link);
    }

   public void invalidateLink(int linkId){
        links.computeIfPresent(linkId,(k,v) -> {
            v.setIsvalid(false);
            return v;
        });
   }

   public void incrementRedirect(int linkId){
        links.computeIfPresent(linkId, (k,v) -> {
            v.setRedirectCount(v.getRedirectCount()+1);
            return v;
        });
   }

    public Link findLinkById(int linkId){
        return links.get(linkId);
    }

   public int getMetric(int linkId){
       return links.get(linkId).getRedirectCount();
   }

    private int nextId(){
        return this.id++;
    }
}
