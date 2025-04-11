package com.desafio.agenda.dataprovider.postgresql.repository;

import com.desafio.agenda.dataprovider.postgresql.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaContatosRepository extends JpaRepository<ContatoModel, Long> {

    @Query("""
            select c from agendacontatos c where c.ativo = true
            """)
    List<ContatoModel> findByAtivo();

}
