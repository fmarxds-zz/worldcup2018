package com.worldcup.worldcup.fifaapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldcup.worldcup.models.Partida;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Match {

    @JsonProperty("fifa_id")
    private Long idFifa;
    @JsonProperty("home_team")
    private Team timeCasa;
    @JsonProperty("away_team")
    private Team timeVisitante;
    @JsonProperty("status")
    private String status;
    @JsonProperty("winner")
    private String vencedor;
    @JsonProperty("winner_code")
    private String vencedorCod;

    public Partida toDomain(){
        Partida partida = new Partida();
        partida.setIdFifa(idFifa);
        partida.setTimeCasa(timeCasa.toDomain());
        partida.setTimeVisitante(timeVisitante.toDomain());
        partida.setStatus(status);
        partida.setVencedor(vencedor);
        partida.setVencedorCod(vencedorCod);
        return partida;
    }
}
