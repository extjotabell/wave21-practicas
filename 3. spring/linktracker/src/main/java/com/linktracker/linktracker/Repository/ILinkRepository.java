package com.linktracker.linktracker.Repository;
import com.linktracker.linktracker.Entity.LinkEntity;

public interface ILinkRepository {
    LinkEntity save(LinkEntity link);
    LinkEntity getById(Integer id);
    void delete(Integer id);
    void update(LinkEntity link);

}
