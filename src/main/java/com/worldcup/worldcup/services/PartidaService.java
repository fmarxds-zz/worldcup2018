package com.worldcup.worldcup.services;

import com.worldcup.worldcup.fifaapi.WorldCupApiClient;
import com.worldcup.worldcup.fifaapi.models.Match;
import com.worldcup.worldcup.models.Partida;
import com.worldcup.worldcup.repositories.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository repository;

    @Autowired
    private WorldCupApiClient client;

    public List<Partida> listaPartidas(){
        return repository.findAll();
    }

    @Scheduled(fixedRate = 600000)
    public void atualizaPartidas(){

        System.out.println("#### ATUALIZANDO PARTIDAS EM: " + LocalTime.now() + " ####");

        List<Partida> partidasNaApi = client.buscaPorPartidasNaApi().stream().map(Match::toDomain).collect(Collectors.toList());

        Integer qtdPartidasNoBanco = repository.findByStatus("completed").size();
        Integer qtdPartidasNaApi = partidasNaApi.stream().filter(partida -> partida.getStatus().equals("completed")).toArray().length;

        System.out.println("partidas no banco: " + qtdPartidasNoBanco);
        System.out.println("partidas na api: " + qtdPartidasNaApi);

        if (qtdPartidasNoBanco < qtdPartidasNaApi) {
            repository.deleteAll();
            repository.save(partidasNaApi);
        }

        System.out.println("#### PARTIDAS ATUALIZADAS EM: " + LocalTime.now() + " ####");

    }

}
