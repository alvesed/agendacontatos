package com.desafio.agenda.entrypoint.rest.mapper.impl;

import com.desafio.agenda.core.domain.Contato;
import com.desafio.agenda.entrypoint.rest.dtos.ContatoResponse;
import com.desafio.agenda.entrypoint.rest.mapper.AgendaContatosMapper;
import org.springframework.stereotype.Service;

@Service
public class AgendaContatosMapperImpl implements AgendaContatosMapper {
    @Override
    public ContatoResponse toContatoResponse(Contato contato) {
        if (contato == null) {
            return null;
        }

        ContatoResponse contatoResponse = new ContatoResponse();
        contatoResponse.setIdContato(contato.getId());
        contatoResponse.setCpf(contato.getCpf());
        contatoResponse.setNome(contato.getNome());
        return contatoResponse;
    }

    @Override
    public Contato toContato(ContatoResponse contatoResponse) {
        if (contatoResponse == null) {
            return null;
        }

        Contato contato = new Contato();
        contato.setId(contatoResponse.getIdContato());
        contato.setCpf(contatoResponse.getCpf());
        contato.setNome(contatoResponse.getNome());
        return contato;
    }
}
