package com.example.jewel.controller;


import com.example.jewel.model.Jewel;
import com.example.jewel.service.IJewelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    final
    IJewelService _jewelService;

    public JewelController(IJewelService _jewelService) {
        this._jewelService = _jewelService;
    }

    @PostMapping("/new")
    public String saveJewel (@RequestBody Jewel Jewel) {
        return _jewelService.saveJewel(Jewel);
    }

    @GetMapping()
    public List<Jewel> getJewels () {

        return _jewelService.getJewels();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteJewel (@PathVariable Long id) {

        return _jewelService.deleteJewel(id);
    }

    @PutMapping ("/update/{id}")
    public String editJewel (@PathVariable Long id,
                            @RequestBody Jewel Jewel) {

        return _jewelService.editJewel(id, Jewel);
    }


}
