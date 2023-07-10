package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;
import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.repository.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService {

    @Autowired
    SaleRepository saleRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        return null;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        return new SaleListResponseDTO(saleRepository.findAll().stream()
                .map(sale -> mapper.map(sale,SaleResponseDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        return mapper.map(saleRepository.findById(id).orElse(null),SaleResponseDTO.class);
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        Optional<Sale> saleResponse = saleRepository.findById(code);

        if(!saleResponse.isPresent())
            return false;

        saleRequestDTO.setId(saleResponse.get().getId());

        saleRepository.save(mapper.map(saleRequestDTO,Sale.class));

        return true;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        Optional<Sale> saleResponse = saleRepository.findById(id);

        if(!saleResponse.isPresent())
            return false;

        saleRepository.delete(saleResponse.get());

        return true;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        return new SaleListResponseDTO(saleRepository.findAllByDate(date)
                .stream()
                .map(sale -> mapper.map(sale,SaleResponseDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        return new ClothesListResponseDTO(saleRepository.findAllByClothId(id).stream()
                .map(sale -> sale.getCloth())
                .map(cloths -> cloths.stream().map(cloth -> mapper.map(cloth, ClothesResponseDTO.class))
                        .collect(Collectors.toList())
                ).findFirst().get());
    }
}
