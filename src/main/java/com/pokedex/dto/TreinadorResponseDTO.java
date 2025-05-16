package com.pokedex.dto;

import com.pokedex.entity.Treinador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreinadorResponseDTO {
    private Long id;
    private String nomeTreinador;
    private Integer idade;
    private String nomePokemon;

    public TreinadorResponseDTO(Treinador treinador) {
        this.id = id;
        this.nomeTreinador = nomeTreinador;
        this.idade = idade;
        this.nomePokemon = treinador.getPokemon().getNomePokemon();
    }
}
