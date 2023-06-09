package com.bootcamp.grupo3.socialmeli.order;

import com.bootcamp.grupo3.socialmeli.dto.response.UserDTO;
import com.bootcamp.grupo3.socialmeli.model.User;

import java.util.Comparator;
import java.util.Map;

public class UserOrder implements Orderable<UserOrderType, UserDTO> {

  @Override
  public Map<UserOrderType, Comparator<UserDTO>> fieldComparator() {
    return Map.ofEntries(
      Map.entry(UserOrderType.DEFAULT, Comparator.naturalOrder()),
      Map.entry(UserOrderType.DESCEND_ORDER, Comparator.reverseOrder())
    );
  }
}
