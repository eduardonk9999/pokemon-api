package com.pokedex.service;

import com.pokedex.dto.TreinadorRequestDTO;
import com.pokedex.entity.Pokemon;
import com.pokedex.entity.Treinador;
import com.pokedex.repository.PokemonRepository;
import com.pokedex.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinadorService {

    private final TreinadorRepository treinadorRepository;
    private final PokemonRepository pokemonRepository;

    public TreinadorService(TreinadorRepository treinadorRepository, PokemonRepository pokemonRepository) {
        this.treinadorRepository = treinadorRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public List<Treinador> findAll() {
        return treinadorRepository.findAll();
    }

    public Optional<Treinador> findById(Long id) {
        return treinadorRepository.findById(id);
    }

    public Treinador save(TreinadorRequestDTO dto) {
        Pokemon pokemon = pokemonRepository.findById(dto.getIdPokemon())
                .orElseThrow(() -> new RuntimeException("Pokémon não encontrado"));

        Treinador treinador = Treinador.builder()
                .nomeTreinador(dto.getNomeTreinador())
                .idade(dto.getIdade())
                .pokemon(pokemon)
                .build();

        // colocar pra enviar para o RabbitMQ
        return treinadorRepository.save(treinador);


    }

    public void delete(Long id) {
        treinadorRepository.deleteById(id);
    }
}