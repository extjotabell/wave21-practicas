package com.jpa.integrador.service;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;
import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;
import com.jpa.integrador.repository.ClothRepository;
import com.jpa.integrador.repository.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService {

    @Autowired
    SaleRepository saleRepository;
    ClothRepository clothRepository;
    ModelMapper mapper = new ModelMapper();
    @Override
    public Boolean addSale(SaleRequestDTO saleRequestDTO) {
        Sale resp = saleRepository.save(mapper.map(saleRequestDTO, Sale.class));
        if(resp != null){
            return true;
        }
        return false;
    }

    @Override
    public SaleListResponseDTO findAllSales() {
        List<Sale> sales = saleRepository.findAll();
        List<SaleResponseDTO> dto = new ArrayList<>();
        sales.forEach(s -> dto.add(mapper.map(sales, SaleResponseDTO.class)));
        return new SaleListResponseDTO(dto);
    }

    @Override
    public SaleResponseDTO findOneSale(Integer id) {
        Optional<Sale> find = saleRepository.findById(id);
        if (!find.isPresent()){
            throw new RuntimeException("No se encontro la venta con id: " + id);
        }

        return mapper.map(find, SaleResponseDTO.class);
    }

    @Override
    public Boolean updateSale(Integer code, SaleRequestDTO saleRequestDTO) {
        if( saleRepository.findById(code) == null) {
            throw new RuntimeException("No se encontro la venta con id: " + code);
        }
        Sale sale1 = mapper.map(saleRequestDTO, Sale.class);
        sale1.setId(code);
        Sale saved = saleRepository.save(sale1);
        if(saved != null)
            return true;
        return false;
    }

    @Override
    public Boolean deleteSale(Integer id) {
        SaleResponseDTO sale = findOneSale(id);
        saleRepository.delete(mapper.map(sale,Sale.class));
        return true;
    }

    @Override
    public SaleListResponseDTO searchSaleByDate(LocalDate date) {
        List<Sale> saleList = saleRepository.findSaleByDate(date);
        return mapper.map(saleList, SaleListResponseDTO.class);
    }

    @Override
    public ClothesListResponseDTO searchClothesBySaleId(Integer id) {
        List<Cloth> listaRopa = saleRepository.findById(id).get().getCloth();
        if(listaRopa.isEmpty()) throw  new RuntimeException("La lista esta vacia para el id "+ id);
        List<ClothesResponseDTO> listaRopaDTO = listaRopa
                .stream()
                .map(c -> mapper.map(c, ClothesResponseDTO.class))
                .collect(Collectors.toList());

        return new ClothesListResponseDTO(listaRopaDTO);
    }
}
