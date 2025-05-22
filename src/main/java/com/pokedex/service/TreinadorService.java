package com.pokedex.service;

import com.pokedex.dto.TreinadorRequestDTO;
import com.pokedex.dto.TreinadorResponseDTO;
import com.pokedex.entity.Pokemon;
import com.pokedex.entity.Treinador;
import com.pokedex.producer.TreinadorProducer;
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
    private final TreinadorProducer producer;


    public TreinadorService(TreinadorRepository treinadorRepository, PokemonRepository pokemonRepository, TreinadorProducer producer) {
        this.treinadorRepository = treinadorRepository;
        this.pokemonRepository = pokemonRepository;
        this.producer = producer;
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


       Treinador saved = treinadorRepository.save(treinador);

       producer.enviarMensagem(new TreinadorResponseDTO(saved));

       return saved;
    }

    public void delete(Long id) {
        treinadorRepository.deleteById(id);
    }
}