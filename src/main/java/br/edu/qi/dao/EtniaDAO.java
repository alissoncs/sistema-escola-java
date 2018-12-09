package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Etnia;

@Repository
public interface EtniaDAO extends JpaRepository<Etnia, Long>{
}
