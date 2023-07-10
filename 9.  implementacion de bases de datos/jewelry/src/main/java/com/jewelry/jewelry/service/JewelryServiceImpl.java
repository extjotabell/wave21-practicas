package com.jewelry.jewelry.service;

import com.jewelry.jewelry.dto.request.JewelryRequestDto;
import com.jewelry.jewelry.dto.response.JewelryResponseDto;
import com.jewelry.jewelry.model.Jewelry;
import com.jewelry.jewelry.repository.IJewelryRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryServiceImpl implements IJewelryService {
    private final IJewelryRepository _iJewelryRepository;
    private ModelMapper modelMapper;

    public JewelryServiceImpl(IJewelryRepository iJewelryRepository) {
        this._iJewelryRepository = iJewelryRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public Long addItem(JewelryRequestDto item) {
        Jewelry editValue = this.modelMapper.map(item, Jewelry.class);
        editValue.setVentaONo(true);
        Jewelry newValue = this._iJewelryRepository.save(editValue);
        return newValue.getNroIdentificatorio();
    }

    @Override
    @Transactional
    public List<JewelryResponseDto> getAllItems() {
        return this._iJewelryRepository.findAll().stream()
                .filter(Jewelry::getVentaONo)
                .map(j -> this.modelMapper.map(j, JewelryResponseDto.class)).toList();
    }

    @Override
    @Transactional
    public void deleteItem(Long itemId) {
        Optional<Jewelry> getById = this._iJewelryRepository.findById(itemId);
        Jewelry editValue = new Jewelry();
        if (getById.isPresent()){
            editValue = getById.get();
            editValue.setVentaONo(false);
        }
        this._iJewelryRepository.save(editValue);
    }

    @Override
    @Transactional
    public JewelryResponseDto updateItem(Long id, JewelryRequestDto item) {
        Jewelry editValue = this.modelMapper.map(item, Jewelry.class);
        editValue.setNroIdentificatorio(id);
        Jewelry newValue = this._iJewelryRepository.save(editValue);
        return this.modelMapper.map(newValue, JewelryResponseDto.class);
    }
}
