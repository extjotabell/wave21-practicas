package com.bootcamp.grupo3.socialmeli.order;

import java.util.Map;

public enum UserOrderType {
    DESCEND_ORDER,
    DEFAULT;

    public static UserOrderType getEnumValue(String a) {
      return Map.ofEntries(
        Map.entry("name_desc", DESCEND_ORDER),
        Map.entry("name_asc", DEFAULT)
      ).get(a);
    }
}
