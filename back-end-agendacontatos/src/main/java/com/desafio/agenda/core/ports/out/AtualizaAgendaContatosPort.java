package com.desafio.agenda.core.ports.out;

import com.desafio.agenda.core.domain.Contato;

public interface AtualizaAgendaContatosPort {

    Contato cadastrar(Contato contato);

    Contato atualizar(Contato contato);

    void inativar(Long id);

}
