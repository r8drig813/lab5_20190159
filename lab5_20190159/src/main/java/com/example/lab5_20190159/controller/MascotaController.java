package com.example.lab5_20190159.controller;

import com.example.lab5_20190159.entity.Mascotas;
import com.example.lab5_20190159.repository.MascotaRepository;
import com.example.lab5_20190159.repository.PersonasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaRepository mascotaRepository;
    private final PersonasRepository personasRepository;

    public MascotaController(MascotaRepository mascotaRepository,
                             PersonasRepository personasRepository) {
        this.mascotaRepository = mascotaRepository;
        this.personasRepository = personasRepository;
    }

    @GetMapping(value = {"/lista"})
    public String listaMascotas(Model model) {

        model.addAttribute("listaMascota", mascotaRepository.findAll());

        return "mascotas/lista";
    }


    @GetMapping("/new")
    public String nuevoProductoFrm(Model model) {
        model.addAttribute("listaPersona",personasRepository.findAll());
        return "mascotas/new";
    }

    @PostMapping("/save")
    public String guardar(Mascotas mascotas, RedirectAttributes attr) {
        mascotaRepository.save(mascotas);
        return "redirect:/mascotas/lista";
    }

    @GetMapping("/edit")
    public String editar(Model model, @RequestParam("id") int id) {

        Optional<Mascotas> optProduct = mascotaRepository.findById(id);

        if (optProduct.isPresent()) {
            Mascotas mascotas = optProduct.get();
            model.addAttribute("mascotas", mascotas);
            model.addAttribute("listaCategorias",personasRepository.findAll());
            return "mascotas/edit";
        } else {
            return "redirect:/mascotas/lista";
        }
    }
}
