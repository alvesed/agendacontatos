package com.desafio.agenda.dataprovider.postgresql;

import com.desafio.agenda.core.domain.Contato;
import com.desafio.agenda.core.ports.in.ConsultaAgendaContatosPort;
import com.desafio.agenda.dataprovider.postgresql.model.ContatoModel;
import com.desafio.agenda.dataprovider.postgresql.repository.AgendaContatosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaAgendaContatosAdapter implements ConsultaAgendaContatosPort {

    @Autowired
    AgendaContatosRepository agendaContatosRepository;

    @Override
    public List<Contato> listar() {
        List<Contato> listContato = new ArrayList<>();
        for (ContatoModel contatoModel : agendaContatosRepository.findByAtivo()) {
            Contato contato = new Contato();
            BeanUtils.copyProperties(contatoModel, contato);
            contato.setCpf(contatoModel.getCpfCnpj());
            listContato.add(contato);
        }
        return listContato;
    }

    @Override
    public Contato consultar(Long id) {
        Optional<ContatoModel> contatoModel = agendaContatosRepository.findById(id);
        Contato contato = new Contato();
        BeanUtils.copyProperties(contatoModel.get(), contato);
        contato.setCpf(contatoModel.get().getCpfCnpj());
        return contato;
    }
}
