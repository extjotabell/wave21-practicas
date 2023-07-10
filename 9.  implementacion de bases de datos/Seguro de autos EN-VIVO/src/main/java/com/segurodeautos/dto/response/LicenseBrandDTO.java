package com.segurodeautos.dto.response;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Data
public class LicenseBrandDTO {
    private String licensePlate;
    private String carBrand;
}
