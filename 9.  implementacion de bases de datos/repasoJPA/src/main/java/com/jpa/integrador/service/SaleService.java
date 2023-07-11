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
        saleRepository.save(mapper.map(saleRequestDTO, Sale.class));
        return true;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        SaleListResponseDTO dto = new SaleListResponseDTO();
        dto.setSales(
                saleRepository.findAll()
                        .stream()
                        .map(sale -> mapper.map(sale, SaleResponseDTO.class))
                        .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        Optional<Sale> sale = saleRepository.findById(id);
        return sale.map(value -> mapper.map(value, SaleResponseDTO.class)).orElse(null);
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        Optional<Sale> sale = saleRepository.findById(code);
        if(sale.isPresent()){
            sale.get().setDate(saleRequestDTO.getDate());
            sale.get().setTotalAmount(saleRequestDTO.getTotalAmount());
            sale.get().setPaymentMethod(saleRequestDTO.getPaymentMethod());
            sale.get().setCloth(saleRequestDTO.getCloth().stream().map(cloth -> mapper.map(cloth, Cloth.class)).collect(Collectors.toList()));
            saleRepository.save(sale.get());
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if(sale.isPresent()){
            saleRepository.delete(sale.get());
            return true;
        }

        return null;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        List<Sale> sales = saleRepository.findByDate(date);
        SaleListResponseDTO dto = new SaleListResponseDTO();
        dto.setSales(
                sales.stream()
                        .map(sale -> mapper.map(sale, SaleResponseDTO.class))
                        .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if(sale.isPresent()){
            ClothesListResponseDTO dto = new ClothesListResponseDTO();
            dto.setClothes(
                    sale.get().getCloth()
                    .stream()
                    .map(cloth -> mapper.map(cloth, ClothesResponseDTO.class))
                    .collect(Collectors.toList()));
            return dto;
        }
        return null;
    }
}
