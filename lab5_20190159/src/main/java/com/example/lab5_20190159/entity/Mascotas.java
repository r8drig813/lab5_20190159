package com.example.lab5_20190159.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Entity
@Getter
@Setter
@Table(name = "mascotas")
public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascotas")
    private int idMascotas;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Personas personas;


    @Column(name = "nombre_mascota", length = 45)
    private String nombre_mascota;

    @Column(name = "genero", length = 45)
    private String genero;

    @Column(name = "edad", length = 45)
    private String edad;

    @Column(name = "fecha_nacimiento", length = 45)
    private String fecha_nacimiento;

    @Column(name = "Vacunado", length = 45)
    private String vacunado;

    @Column(name = "Desparasitado", length = 45)
    private String desparasitado;

}
