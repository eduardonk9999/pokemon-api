package com.pokedex.controller;

import com.pokedex.entity.Treinador;
import com.pokedex.service.TreinadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/treinadores")
public class TreinadorController {
    private final TreinadorService treinadorService;

    public TreinadorController(TreinadorService treinadorService) {
        this.treinadorService = treinadorService;
    }

    @GetMapping
    public List<Treinador> listarTodos() {
        return treinadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treinador> buscarPorId(@PathVariable Long id) {
        Treinador treinador = treinadorService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Treinador não encontrado."));
        return ResponseEntity.ok(treinador);
    }

    @PostMapping
    public ResponseEntity<Treinador> criar(@RequestBody Treinador treinador) {
        Treinador criado = treinadorService.save(treinador);
        return ResponseEntity.status(201).body(criado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        treinadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
