package com.pokedex.service;

import com.pokedex.repository.PokemonRepository;
import com.pokedex.repository.TreinadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class TreinadorServiceTest {
    private TreinadorService service;
    private TreinadorRepository repository;
    private PokemonRepository pokemonRepository;

    @BeforeEach
    void setUp() {
        repository = mock(TreinadorRepository.class); // simula um repository fake
        pokemonRepository = mock(PokemonRepository.class) // simula o repository do pokemon
        service = new TreinadorService(repository, pokemonRepository, null); // intancia o service
    }

    @Test
    void deveSalvarTreinadorComSucesso() {

    }
}
