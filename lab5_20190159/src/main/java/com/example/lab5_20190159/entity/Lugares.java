package com.example.lab5_20190159.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "lugares")
public class Lugares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares")
    private int idLugares;
    @Column(name = "nombre_lugar", length = 30)
    private String nombre_lugar;
    @Column(name = "descrip_lugar", length = 30)
    private String descrip_lugar;
    @Column(name = "fecha_lugar", length = 30)
    private Date fecha_lugar;

}
