package com.example.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="configuracion")
public class Configuracion {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_Minimo")
    private int stockMin;

    private double porcentajeCostoMax;
}
