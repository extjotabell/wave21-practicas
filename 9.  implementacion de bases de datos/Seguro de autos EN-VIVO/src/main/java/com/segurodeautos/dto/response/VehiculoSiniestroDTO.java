package com.segurodeautos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class VehiculoSiniestroDTO {
    private List<LicenseBrandModelDTO> licenseBrandModelDTOS;
    private Long totalEconomicLost;
}
