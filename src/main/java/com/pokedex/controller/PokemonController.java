package com.pokedex.controller;

import com.pokedex.entity.Pokemon;
import com.pokedex.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> listarTodos() {
        return pokemonService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> buscaPorId(@PathVariable Long id) {
        Pokemon pokemon = pokemonService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon não encontrado."));
        return ResponseEntity.ok(pokemon);
    }

    @PostMapping
    public ResponseEntity<Pokemon> criar(@RequestBody Pokemon pokemon) {
        Pokemon criado = pokemonService.save(pokemon);
        return ResponseEntity.status(201).body(criado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pokemonService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
