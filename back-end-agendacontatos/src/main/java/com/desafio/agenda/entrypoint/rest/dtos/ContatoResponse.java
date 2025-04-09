package com.desafio.agenda.entrypoint.rest.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ContatoResponse {

    private Long idContato;
    private Long cpf;
    private String nome;
//    private Boolean ativo;
//    private LocalDateTime dataCriacao;
//    private LocalDateTime dataAtualizacao;
//    private String cep;
//    private String endereco;
//    private String numero;
//    private String complemento;
//    private String bairro;
//    private String cidade;
//    private String estado;
//    private String latitude;
//    private String longitude;
//    private String phoneNumber;

    public ContatoResponse() {
    }

    public ContatoResponse(Long idContato, Long cpf, String nome) {
        this.idContato = idContato;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
