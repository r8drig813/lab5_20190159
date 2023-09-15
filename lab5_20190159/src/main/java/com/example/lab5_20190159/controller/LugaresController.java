package com.example.lab5_20190159.controller;

import com.example.lab5_20190159.entity.Lugares;
import com.example.lab5_20190159.entity.Mascotas;
import com.example.lab5_20190159.repository.LugaresRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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

    @GetMapping("/new")
    public String nuevoProductoFrm() {
        return "lugares/new";
    }

    @PostMapping("/save")
    public String guardar(Lugares lugares, RedirectAttributes attr) {
        lugaresRepository.save(lugares);
        return "redirect:/lugares/lista";
    }


    @GetMapping("/edit")
    public String editar(Model model, @RequestParam("id") int id) {

        Optional<Lugares> optProduct = lugaresRepository.findById(id);

        if (optProduct.isPresent()) {
            Lugares lugares = optProduct.get();
            return "mascotas/edit";
        } else {
            return "redirect:/mascotas/lista";
        }
    }

}
