package com.pokedex.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreinadorRequestDTO {
    @NotBlank(message = "Nome do treinador é obrigatório")
    private String nomeTreinador;

    @NotNull(message = "Idade é obrigatória")
    @Min(value = 1, message = "Idade deve ser maior que zero")
    private Integer idade;

    @NotNull(message = "ID do Pokémon é obrigatório")
    private Long idPokemon;
}
