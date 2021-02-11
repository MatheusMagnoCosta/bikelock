package br.app.bikelock.bikelock.dto;

import br.app.bikelock.bikelock.model.TipoBicicleta;
import br.app.bikelock.bikelock.model.TipoQuadro;
import lombok.Data;

@Data
public class BicicletaDTO {
    private Long id;
    private String nome;
    private String numeroSerie;
    private String tag;
    private TipoBicicleta tipo;
    private String marca;
    private String modelo;
    private String cor;
    private TipoQuadro tipoQuadro;
    private String informacoesAdicionais;
    
}
