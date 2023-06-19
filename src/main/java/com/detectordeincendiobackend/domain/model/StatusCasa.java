package com.detectordeincendiobackend.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StatusCasa {
    public StatusCasa(String temperatura, String umidade, String hasGas, String hasChama, String hasIncendio) {
        this.temperatura = Long.parseLong(temperatura);
        this.umidade = Long.parseLong(umidade);
        this.hasGas = "1".equals(hasGas);
        this.hasChama = "1".equals(hasChama);
        this.hasIncendio = "1".equals(hasIncendio);

    }

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long temperatura;
    private Long umidade;
    private Boolean hasGas;
    private Boolean hasChama;
    private Boolean hasIncendio;
}
