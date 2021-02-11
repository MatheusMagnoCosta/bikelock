package br.app.bikelock.bikelock.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String municipio;
    private String uf;
    private String telefone;

}
