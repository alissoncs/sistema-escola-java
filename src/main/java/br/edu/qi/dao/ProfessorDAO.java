package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Professor;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Long>{
}
