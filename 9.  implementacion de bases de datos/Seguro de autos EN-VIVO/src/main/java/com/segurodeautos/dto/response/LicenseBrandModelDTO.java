package com.segurodeautos.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LicenseBrandModelDTO {
    private String licensePlate;
    private String carBrand;
    private String model;
}
