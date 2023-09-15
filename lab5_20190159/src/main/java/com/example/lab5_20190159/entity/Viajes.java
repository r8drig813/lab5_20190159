package com.example.lab5_20190159.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Entity
@Getter
@Setter
@Table(name = "viajes")
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes")
    private int idViajes;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Personas personas;

    @ManyToOne
    @JoinColumn(name = "Lugares_idLugares")
    private Lugares lugares;

    @Column(name = "punto_recojo", length = 45)
    private String puntorecojo;

    @Column(name = "cant_personas", length = 45)
    private String cantpersonas;

    @Column(name = "cant_perros", length = 45)
    private String cantperros;


}
