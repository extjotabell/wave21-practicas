package com.example.jewel.service;

import com.example.jewel.model.Jewel;
import com.example.jewel.repository.IJewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {

    final
    IJewelRepository _jewelRepository;

    public JewelService(IJewelRepository _jewelRepository) {
        this._jewelRepository = _jewelRepository;
    }

    @Override
    public String saveJewel(Jewel jewel) {
       _jewelRepository.save(jewel);

       return "Jewel with id " + jewel.getId() + " correctly saved";
    }

    @Override
    public List<Jewel> getJewels() {

        return _jewelRepository.findAll().stream().filter(Jewel::isSold).toList();

    }

    @Override
    public Jewel findJewel(Long id) {
        return _jewelRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteJewel(Long id) {

        Jewel jewel= this.findJewel(id);
        jewel.setSold(false);
        this.saveJewel(jewel);

        return "The jewel with id " + jewel.getId() + " cannot be sold";
    }

    @Override
    public String editJewel(Long id, Jewel newJewel) {

        Jewel jewel = this.findJewel(id);

        jewel.setName(newJewel.getName());
        jewel.setMaterial(newJewel.getMaterial());
        jewel.setWeight(newJewel.getWeight());
        jewel.setPeculiarity(newJewel.getPeculiarity());
        jewel.setHas_stone(newJewel.isHas_stone());
        jewel.setSold(newJewel.isSold());

        this.saveJewel(jewel);
        return jewel.toString();

    }
}
