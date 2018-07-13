package com.worldcup.worldcup.fifaapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldcup.worldcup.models.Time;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Team {

    @JsonProperty("country")
    private String pais;
    @JsonProperty("code")
    private String codigo;
    @JsonProperty("goals")
    private Integer gols;

    public Time toDomain() {
        Time time = new Time();
        time.setPais(pais);
        time.setCodigo(codigo);
        time.setGols(gols);
        return time;
    }
}
