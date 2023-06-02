package com.bootcamp.redirectenvivo.repository;

import com.bootcamp.redirectenvivo.model.Link;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class LinkRepository implements LinkRepositoryInterface{
    Map<Integer,Link> linkMap;

    public LinkRepository(){
        linkMap = new HashMap<>();
    }

    @Override
    public Link createLink(Link link){
        Random rand = new Random();
        link.setLinkId(rand.nextInt());
        link.setCounter(0);
        link.setPassword(link.getPassword());
        linkMap.put(link.getLinkId(), link);
        return link;
    }

    @Override
    public List<Link> getAll(){
        List<Link> result = new ArrayList<>();
        linkMap.forEach((id,link) -> {
            result.add(link);
        });
        return result;
    }

    @Override
    public Link getLinkById(int linkId, String password) {
        AtomicReference<Link> result = new AtomicReference<>(new Link());
        linkMap.forEach((id,link) -> {
            if(id == linkId && link.getIsActive()){
                if(password.equals(link.getPassword())){
                    result.set(link);
                    link.setCounter(link.getCounter() + 1);
                }else {
                    Link temp = new Link();
                    temp.setLinkId(-1);
                    temp.setUrl("empty");
                    result.set(temp);
                }
            }
        });
        return result.get().getUrl() != null ? result.get() : null;
    }

    @Override
    public Link getLinkById(int linkId) {
        AtomicReference<Link> result = new AtomicReference<>(new Link());
        linkMap.forEach((id,link) -> {
            if(id == linkId && link.getIsActive()){
                result.set(link);
                link.setCounter(link.getCounter() + 1);
            }
        });
        return result.get().getUrl() != null ? result.get() : null;
    }

    @Override
    public Link invalidate(int linkId) {
        AtomicReference<Link> result = new AtomicReference<>(new Link());
        linkMap.forEach((id,link) -> {
            if(id == linkId && link.getIsActive()){
                result.set(link);
                link.setIsActive(false);
            }
        });
        return result.get().getUrl() != null ? result.get() : null;
    }
}
