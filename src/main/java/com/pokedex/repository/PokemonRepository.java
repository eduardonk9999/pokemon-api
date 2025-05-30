package com.pokedex.repository;

import com.pokedex.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository <Pokemon, Long>{
}
