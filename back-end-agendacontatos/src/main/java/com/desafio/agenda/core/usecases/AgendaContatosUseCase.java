package com.desafio.agenda.core.usecases;

import com.desafio.agenda.core.domain.Contato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaContatosUseCase {

    public List<Contato> listar() {
        return List.of(new Contato(1L, 12345678901L, "Edson F. Alves"));
    }

    public Contato buscar(Long id) {
        return new Contato(1L, 12345678901L, "Edson F. Alves");
    }

    public Contato cadastrar(Contato contato) {
        return contato;
    }

    public Contato atualizar(Contato contato) {
        return contato;
    }

    public void inativar(Long id) {
    }

}
