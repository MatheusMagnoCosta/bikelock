package br.app.bikelock.bikelock.model;

import java.util.List;

import lombok.Data;

@Data
public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String municipio;
    private String uf;
    private String telefone;
    private List<Bicicleta> bicicletas;

}
