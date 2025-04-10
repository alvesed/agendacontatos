package com.desafio.agenda.core.usecases;

import com.desafio.agenda.core.domain.Contato;
import com.desafio.agenda.core.ports.in.ConsultaAgendaContatosPort;
import com.desafio.agenda.core.ports.out.AtualizaAgendaContatosPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaContatosUseCase {

    @Autowired
    ConsultaAgendaContatosPort consultaAgendaContatosPort;

    @Autowired
    AtualizaAgendaContatosPort atualizaAgendaContatosPort;

    public List<Contato> listar() {
        return consultaAgendaContatosPort.listar();
    }

    public Contato buscar(Long id) {
        return consultaAgendaContatosPort.consultar(id);
    }

    public Contato cadastrar(Contato contato) {
        try {
            contato = atualizaAgendaContatosPort.cadastrar(contato);
        } catch (Exception e) {
            e.printStackTrace();
            throw (e);
        }
        return contato;
    }

    public Contato atualizar(Contato contato) {
        return atualizaAgendaContatosPort.atualizar(contato);
    }

    public void inativar(Long id) {
        atualizaAgendaContatosPort.inativar(id);
    }

}
