package com.desafio.agenda.entrypoint.rest.mapper;

import com.desafio.agenda.core.domain.Contato;
import com.desafio.agenda.entrypoint.rest.dtos.ContatoResponse;

public interface AgendaContatosMapper {

    ContatoResponse toContatoResponse(Contato contato);

    Contato toContato(ContatoResponse contatoResponse);
}
