package com.bootcamp.grupo3.socialmeli.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public record PostPromoMetricDTO(int userId, String userName, int promoProductsCount) {
}
