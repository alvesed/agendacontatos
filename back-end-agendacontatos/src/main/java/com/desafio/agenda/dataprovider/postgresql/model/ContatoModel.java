package com.desafio.agenda.dataprovider.postgresql.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Entity(name = "agendacontatos")
public class ContatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(name = "cpf_cnpj")
    private Long cpfCnpj;

    @Nonnull
    private String nome;

    private Boolean ativo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public ContatoModel(){}

    public ContatoModel(Long id, Long cpfCnpj, String nome) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao() {
        if (this.getDataCriacao() == null) {
            this.setDataCriacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        }
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao() {
        if (this.getDataAtualizacao() == null) {
            this.setDataAtualizacao(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        }
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ContatoModel that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(cpfCnpj, that.cpfCnpj) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpfCnpj, nome);
    }
}
