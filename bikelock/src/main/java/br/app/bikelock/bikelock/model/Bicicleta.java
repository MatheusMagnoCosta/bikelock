package br.app.bikelock.bikelock.model;

import lombok.Data;

@Data
public class Bicicleta {
    private Long id;
    private String nome;
    private String numeroSerie;
    private String tag;
    private TipoBicicleta tipo;
    private String marca;
    private String modelo;
    private String cor;
    private TipoQuadro tipoQuadro;
}
