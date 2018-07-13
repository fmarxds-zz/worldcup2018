package com.worldcup.worldcup.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "partidas")
public class Partida {

    private String id;
    private Long idFifa;
    private Time timeCasa;
    private Time timeVisitante;
    private String status;
    private String vencedor;
    private String vencedorCod;

}
