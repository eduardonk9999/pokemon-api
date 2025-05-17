package com.pokedex.controller;

import com.pokedex.dto.TreinadorRequestDTO;
import com.pokedex.dto.TreinadorResponseDTO;
import com.pokedex.entity.Treinador;
import com.pokedex.service.TreinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary = "Lista de todos os treinadores")
    @GetMapping
    public List<Treinador> listarTodos() {
        return treinadorService.findAll();
    }

    @Operation(summary = "Busca treinador por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrado"),
            @ApiResponse(responseCode = "404", description = "Não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Treinador> buscarPorId(@PathVariable Long id) {
        Treinador treinador = treinadorService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Treinador não encontrado."));
        return ResponseEntity.ok(treinador);
    }

    @PostMapping
    public ResponseEntity<TreinadorResponseDTO> criar(@RequestBody @Valid TreinadorRequestDTO dto) {
        Treinador treinador = treinadorService.save(dto);
        TreinadorResponseDTO response = new TreinadorResponseDTO(treinador);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        treinadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
