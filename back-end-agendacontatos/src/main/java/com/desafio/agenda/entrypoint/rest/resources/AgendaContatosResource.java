package com.desafio.agenda.entrypoint.rest.resources;

import com.desafio.agenda.core.domain.Contato;
import com.desafio.agenda.core.usecases.AgendaContatosUseCase;
import com.desafio.agenda.entrypoint.rest.dtos.ContatoResponse;
import com.desafio.agenda.entrypoint.rest.mapper.AgendaContatosMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agendacontatos")
public class AgendaContatosResource {

    @Autowired
    private AgendaContatosUseCase agendaContatosUseCase;

    @Autowired
    private AgendaContatosMapper agendaContatosMapper;

    @GetMapping
    public List<ContatoResponse> listar() {
        var listAgendaContatos = agendaContatosUseCase.listar();
        return toListContatoResponse(listAgendaContatos);
    }

    @GetMapping("/{id}")
    public ContatoResponse buscar(@PathVariable Long id) {
        var contato = agendaContatosUseCase.buscar(id);
        return toContatoResponse(contato);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoResponse cadastrar(@RequestBody ContatoResponse contatoResponse) {
        var contato = toContato(contatoResponse);
        Contato contatoCadastrado;
        try {
            contatoCadastrado = agendaContatosUseCase.cadastrar(contato);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "O sistema apresentou falha. Contate o administrador", e);
        }
        return toContatoResponse(contatoCadastrado);
    }

    @PutMapping("/{id}")
    public ContatoResponse atualizar(@PathVariable Long id, @RequestBody ContatoResponse contatoResponse) {
        var contato = toContato(contatoResponse);
        Contato contatoAtual = agendaContatosUseCase.buscar(id);
        BeanUtils.copyProperties(contato, contatoAtual, "id");
        return toContatoResponse(agendaContatosUseCase.atualizar(contatoAtual));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@PathVariable Long id) {
        agendaContatosUseCase.inativar(id);
    }

    private Contato toContato(ContatoResponse contatoResponse) {
        return this.agendaContatosMapper.toContato(contatoResponse);
    }

    private List<ContatoResponse> toListContatoResponse(List<Contato> listContatos) {
        return listContatos.stream()
                .map(this.agendaContatosMapper::toContatoResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    private ContatoResponse toContatoResponse(Contato contato) {
        return this.agendaContatosMapper.toContatoResponse(contato);
    }

}

