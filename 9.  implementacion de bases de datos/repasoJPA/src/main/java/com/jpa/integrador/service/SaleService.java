package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.repository.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
        return null;
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        return null;
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        return null;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        return null;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        return null;
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        return null;
    }
}
