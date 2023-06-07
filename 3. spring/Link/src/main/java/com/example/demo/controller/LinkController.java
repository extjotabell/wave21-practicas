package com.example.demo.controller;

import com.example.demo.dto.LinkDTOCreate;
import com.example.demo.dto.LinkDTOId;
import com.example.demo.dto.LinkDTORequest;
import com.example.demo.dto.LinkDTOResponse;
import com.example.demo.model.Link;
import com.example.demo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LinkController {

    @Autowired
    LinkService service;

    //@GetMapping("/link/")
    @RequestMapping(value = "/link/", headers = {"id = id", "password = password"}, method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView redirectTest(ModelMap model ,@RequestParam int id, String password){
        LinkDTORequest linkRequest = new LinkDTORequest(id, password);
        String url = service.getById(linkRequest);
        return new ModelAndView(url, model);
    }

    @PostMapping("/")
    public ResponseEntity<LinkDTOId> createlink(@RequestBody LinkDTOCreate linkDTO){
        return new ResponseEntity<>(service.save(linkDTO), HttpStatus.OK);
    }

    /*
    @GetMapping("/redirectedUrl")
    public ResponseEntity<?> redirectWithUsingRedirectPrefix() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }
    */

}
