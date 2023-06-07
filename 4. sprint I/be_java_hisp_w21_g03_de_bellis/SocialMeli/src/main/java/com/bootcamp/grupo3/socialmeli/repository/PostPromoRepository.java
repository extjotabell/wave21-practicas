package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.PostPromo;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostPromoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostPromoRepository implements IPostPromoRepository {
  List<PostPromo> promos = new ArrayList<>();


  @Override
  public int save(PostPromo p) {
    p.setId(promos.size());
    promos.add(p);

    return p.getId();
  }

  @Override
  public List<Integer> findAllPromosByUser(int userId) {
    return promos
      .stream()
      .map(PostPromo::getPostId)
      .toList();
  }
}
