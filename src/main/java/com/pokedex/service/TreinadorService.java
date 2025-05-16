package com.pokedex.service;

import com.pokedex.entity.Treinador;
import com.pokedex.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinadorService {
    @Autowired
    private TreinadorRepository treinadorRepository;

    public List<Treinador> findAll() {
        return treinadorRepository.findAll();
    }

    public Optional<Treinador> findById(Long id) {
        return treinadorRepository.findById(id);
    }

    public Treinador save(Treinador treinador) {
        return treinadorRepository.save(treinador);
    }

    public void delete(Long id) {
        treinadorRepository.deleteById(id);
    }
}
