package com.bootcamp.grupo3.socialmeli.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;

@Setter
@Getter
public class PostPromo {
  int id;
  int postId;
  boolean hasPromo;
  double discount;

  public PostPromo(boolean hasPromo, double discount) {
    this.hasPromo = hasPromo;
    this.discount = discount;
  }
}

