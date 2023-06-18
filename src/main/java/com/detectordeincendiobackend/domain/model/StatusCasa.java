package com.detectordeincendiobackend.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatusCasa {
    public StatusCasa(String temperatura, String humidade, String hasGas, String hasChama) {
        this.temperatura = Long.parseLong(temperatura);
        this.humidade = Long.parseLong(humidade);
        this.hasGas = Boolean.parseBoolean(hasGas);
        this.hasChama = Boolean.parseBoolean(hasChama);
    }
    private Long temperatura;
    private Long humidade;
    private Boolean hasGas;
    private Boolean hasChama;
}
