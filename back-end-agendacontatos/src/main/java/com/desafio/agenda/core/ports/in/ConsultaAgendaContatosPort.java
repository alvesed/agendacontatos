package com.desafio.agenda.core.ports.in;

import com.desafio.agenda.core.domain.Contato;

import java.util.List;

public interface ConsultaAgendaContatosPort {

    List<Contato> listar();

    Contato consultar(Long id);

}
