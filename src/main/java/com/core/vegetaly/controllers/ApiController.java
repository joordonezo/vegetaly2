package com.core.vegetaly.controllers;

import com.core.vegetaly.domain.Individuo;
import com.core.vegetaly.respositories.IndividuoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private IndividuoRepository individuoRepository;

    @GetMapping("/all")
    public List<Individuo> all(){
        return individuoRepository.findAll();
    }
}
