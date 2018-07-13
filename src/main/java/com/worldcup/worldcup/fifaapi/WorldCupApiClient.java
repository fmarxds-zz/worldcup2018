package com.worldcup.worldcup.fifaapi;

import com.worldcup.worldcup.fifaapi.models.Match;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "world-cup", url = "https://worldcup.sfg.io")
public interface WorldCupApiClient {

    @GetMapping(value = "/matches")
    List<Match> buscaPorPartidasNaApi();

}
