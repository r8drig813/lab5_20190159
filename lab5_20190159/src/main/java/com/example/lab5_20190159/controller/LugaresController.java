package com.example.lab5_20190159.controller;

import com.example.lab5_20190159.repository.LugaresRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lugares")
public class LugaresController {

    private final LugaresRepository lugaresRepository;

    public LugaresController(LugaresRepository lugaresRepository) {
        this.lugaresRepository = lugaresRepository;
    }

    @GetMapping(value = {"/lista"})
    public String listaViajes(Model model) {

        model.addAttribute("listaLugares", lugaresRepository.findAll());

        return "lugares/lista";
    }
}
