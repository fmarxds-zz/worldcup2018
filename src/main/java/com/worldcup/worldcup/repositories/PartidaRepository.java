package com.worldcup.worldcup.repositories;

import com.worldcup.worldcup.models.Partida;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartidaRepository extends MongoRepository<Partida, String> {

    List<Partida> findByStatus(String status);
    List<Partida> findAll();

}
