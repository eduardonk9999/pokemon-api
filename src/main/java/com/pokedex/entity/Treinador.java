package com.pokedex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Treinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeTreinador;

    @Column(nullable = false)
    private Integer idade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;
}
