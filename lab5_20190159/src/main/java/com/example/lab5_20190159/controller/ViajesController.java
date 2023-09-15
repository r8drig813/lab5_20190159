package com.example.lab5_20190159.controller;

import com.example.lab5_20190159.entity.Viajes;
import com.example.lab5_20190159.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/viajes")
public class ViajesController {

    private final ViajesRepository viajesRepository;

    public ViajesController(ViajesRepository viajesRepository) {
        this.viajesRepository = viajesRepository;
    }

    @GetMapping(value = {"/lista"})
    public String listaViajes(Model model) {

        model.addAttribute("listaViajes", viajesRepository.findAll());

        return "viajes/lista";
    }


}
