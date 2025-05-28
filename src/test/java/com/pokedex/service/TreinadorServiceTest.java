package com.pokedex.service;

import com.pokedex.dto.TreinadorRequestDTO;
import com.pokedex.dto.TreinadorResponseDTO;
import com.pokedex.entity.Pokemon;
import com.pokedex.entity.Treinador;
import com.pokedex.producer.TreinadorProducer;
import com.pokedex.repository.PokemonRepository;
import com.pokedex.repository.TreinadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.util.AssertionErrors;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class TreinadorServiceTest {
    private TreinadorService service;
    private TreinadorRepository repository;
    private PokemonRepository pokemonRepository;
    private TreinadorProducer producer;

    @BeforeEach
    void setUp() {
        repository = mock(TreinadorRepository.class); // simula um repository fake
        pokemonRepository = mock(PokemonRepository.class); // simula o repository do pokemon
        producer = mock(TreinadorProducer.class); // inicia - simula producer
        service = new TreinadorService(repository, pokemonRepository, producer); // intancia o service
    }

    @Test
    void deveSalvarTreinadorComSucesso() {
        TreinadorRequestDTO dto = new TreinadorRequestDTO("Ash", 10, 1L);
        Pokemon pokemon = new Pokemon(1L, "Pikachu", "Eletrico", new ArrayList<>());

        when(pokemonRepository.findById(1L)).thenReturn(Optional.of(pokemon));
        when(repository.save(any())).thenReturn(new Treinador(1L, "Ash", 10, pokemon));

        Treinador treinador = service.save(dto);

        // Assert (verifica)
        assertNotNull(treinador);
        assertEquals("Ash", treinador.getNomeTreinador());
        assertEquals("Pikachu", treinador.getPokemon().getNomePokemon());

    }

    @Test
    void deveLancarExcecaoQuandoPokemonNaoExistir() {
        TreinadorRequestDTO dto = new TreinadorRequestDTO("Misty", 12, 99L);
        when(pokemonRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.save(dto);
        });

        assertEquals("Pokémon não encontrado com ID: 99", exception.getMessage());

        verify(producer, never()).enviarMensagem(any());
    }
}
