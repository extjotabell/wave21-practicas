package com.bootcamp.redirectenvivo.repository;

import com.bootcamp.redirectenvivo.model.Link;

import java.util.List;

public interface LinkRepositoryInterface {

    Link createLink(Link link);

    List<Link> getAll();

    Link getLinkById(int linkId, String password);

    Link getLinkById(int linkId);

    Link invalidate(int linkId);
}
