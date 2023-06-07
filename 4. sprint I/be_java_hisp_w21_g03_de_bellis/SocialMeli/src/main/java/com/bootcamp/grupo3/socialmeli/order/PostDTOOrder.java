package com.bootcamp.grupo3.socialmeli.order;

import com.bootcamp.grupo3.socialmeli.dto.response.PostResponseDTO;

import java.lang.constant.Constable;
import java.util.Comparator;
import java.util.Map;

public class PostDTOOrder implements Orderable<Constable, PostResponseDTO> {
  @Override
  public Map<Constable, Comparator<PostResponseDTO>> fieldComparator() {
    return Map.ofEntries(
      Map.entry(PostOrderType.DATE_ASC, Comparator.comparing(PostResponseDTO::date)),
      Map.entry(PostOrderType.PRICE_ASC, Comparator.comparing(PostResponseDTO::price)),
      Map.entry(PostOrderType.PRICE_DESC, Comparator.comparing(PostResponseDTO::price).reversed()),
      Map.entry(PostOrderType.DEFAULT, Comparator.comparing(PostResponseDTO::date).reversed())
    );
  }
}
