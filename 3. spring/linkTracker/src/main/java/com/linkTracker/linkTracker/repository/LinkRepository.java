package com.linkTracker.linkTracker.repository;

import com.linkTracker.linkTracker.dto.LinkDTO;
import com.linkTracker.linkTracker.model.Link;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository {
    Map<Integer, Link> repoLink;

    public LinkRepository(Map<Integer, LinkDTO> repoLink) {
        this.repoLink = new HashMap<>();
    }
    public boolean saveLink(Link model){
        if(repoLink.containsKey(model.getId())){
            return false;
        }
        else {
            repoLink.put(model.getId(), model);
            return true;
        }
    }
    public Link findById(int linkId){
        if (repoLink.containsKey(linkId)){
            return repoLink.get(linkId);
        }
        else return null;
    }


}
