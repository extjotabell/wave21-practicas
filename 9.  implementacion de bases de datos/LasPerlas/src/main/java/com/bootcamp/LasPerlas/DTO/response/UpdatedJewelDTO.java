package com.bootcamp.LasPerlas.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdatedJewelDTO {
    private int statusCode;
    private JewelDTO updatedJewel;
}
