package com.example.demo.repository;

import com.example.demo.dto.LinkDTORequest;
import com.example.demo.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {

    Integer count=0;

    List<Link> linkList = new ArrayList<>();
    @Override
    public Link save(Link link) {
        linkList.add(link);
        count++;
        return link;
    }

    @Override
    public Link getById(LinkDTORequest linkdtorequest) {
        Optional<Link> linkgeted =  linkList.stream().filter(link -> link.getId() == linkdtorequest.getId() && link.getPassword().equals(linkdtorequest.getPassword())).findFirst();
        if(linkgeted.isPresent()) {
            return  linkgeted.get();
        }
        return null;
    }

    public Integer getId(){
        return count;
    }
}
