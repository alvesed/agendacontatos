package com.desafio.agenda.dataprovider.postgresql;

import com.desafio.agenda.core.domain.Contato;
import com.desafio.agenda.core.ports.out.AtualizaAgendaContatosPort;
import com.desafio.agenda.dataprovider.postgresql.model.ContatoModel;
import com.desafio.agenda.dataprovider.postgresql.repository.AgendaContatosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizaAgendaContatosAdapter implements AtualizaAgendaContatosPort {

    @Autowired
    AgendaContatosRepository agendaContatosRepository;

    @Override
    public Contato cadastrar(Contato contato) {
        ContatoModel contatoModel = new ContatoModel(
                contato.getId(),
                contato.getCpf(),
                contato.getNome()
        );
        contatoModel.setDataCriacao();
        try {
            contatoModel = agendaContatosRepository.save(contatoModel);
        } catch (Exception e) {
            e.printStackTrace();
            throw (e);
        }
        contato.setId(contatoModel.getId());
        return contato;
    }

    @Override
    public Contato atualizar(Contato contato) {
        Optional<ContatoModel> contatoModel = agendaContatosRepository.findById(contato.getId());
        BeanUtils.copyProperties(contato, contatoModel.get());
        contatoModel.get().setDataAtualizacao();
        agendaContatosRepository.save(contatoModel.get());
        return contato;
    }

    @Override
    public void inativar(Long id) {
        Optional<ContatoModel> contatoModel = agendaContatosRepository.findById(id);
        contatoModel.get().setAtivo(false);
        contatoModel.get().setDataAtualizacao();
        agendaContatosRepository.save(contatoModel.get());
    }
}
