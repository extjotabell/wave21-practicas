package com.bootcamp.grupo3.socialmeli.order;

import java.util.Comparator;
import java.util.Map;

public interface Orderable<E, T> {
  Map<E, Comparator<T>> fieldComparator();
  default Comparator<T> getComparator(E key) {
    return this.fieldComparator().get(key);
  }
}
