package com.worldcup.worldcup;

import com.worldcup.worldcup.fifaapi.WorldCupApiClient;
import com.worldcup.worldcup.fifaapi.models.Match;
import com.worldcup.worldcup.models.Partida;
import com.worldcup.worldcup.repositories.PartidaRepository;
import com.worldcup.worldcup.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class WorldcupApplication {

    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private WorldCupApiClient client;

    public static void main(String[] args) {
        SpringApplication.run(WorldcupApplication.class, args);
    }

    @PostConstruct
    public void populaDatabase(){
        if (partidaRepository.count() <= 0) {
            List <Partida> partidas = client.buscaPorPartidasNaApi().stream().map(Match::toDomain).collect(Collectors.toList());
            partidaRepository.save(partidas);
        }

    }

}
