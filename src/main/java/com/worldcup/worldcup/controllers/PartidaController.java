package com.worldcup.worldcup.controllers;

import com.worldcup.worldcup.models.Partida;
import com.worldcup.worldcup.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    private PartidaService service;

    @GetMapping
    public ResponseEntity<List<Partida>> buscaPartidas() {
        return ResponseEntity.ok(service.listaPartidas());
    }

}
