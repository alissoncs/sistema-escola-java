package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Turma;
@Repository
public interface TurmaDAO extends JpaRepository<Turma, Long>{
}
