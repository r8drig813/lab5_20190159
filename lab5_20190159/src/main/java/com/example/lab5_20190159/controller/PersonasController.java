package com.example.lab5_20190159.controller;

import com.example.lab5_20190159.repository.PersonasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personas")
public class PersonasController {

    private final PersonasRepository personasRepository;

    public PersonasController(PersonasRepository personasRepository) {
        this.personasRepository = personasRepository;
    }

    @GetMapping(value = {"/lista"})
    public String listaViajes(Model model) {

        model.addAttribute("listaPersonas", personasRepository.findAll());

        return "personas/lista";
    }
}
