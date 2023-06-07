package com.bootcamp.grupo3.socialmeli.order;

import java.util.Map;

public enum PostOrderType {

  PRICE_ASC,
  PRICE_DESC,
  DATE_ASC,
  DEFAULT;

  public static PostOrderType getEnumValue(String a) {
    return Map.ofEntries(
      Map.entry("price_asc", PRICE_ASC),
      Map.entry("price_desc", PRICE_DESC),
      Map.entry("date_asc", DATE_ASC),
      Map.entry("date_desc", DEFAULT)
    ).get(a);
  }
}
