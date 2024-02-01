package br.com.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(String Valor,
                           String Marca,
                           @JsonAlias("AnoModelo") Integer ano,
                           String Modelo) {
}
