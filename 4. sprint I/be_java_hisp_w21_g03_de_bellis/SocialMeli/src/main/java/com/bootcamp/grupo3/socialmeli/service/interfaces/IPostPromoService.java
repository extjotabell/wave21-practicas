package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostIdPromoDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.PostPromoMetricDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.model.PostPromo;

public interface IPostPromoService {
  PostIdPromoDTO createPostPromo(PostPromoDTO p) throws UserPermissionException;
  PostPromoMetricDTO getMetricPostPromo(String token) throws UserPermissionException;
}
