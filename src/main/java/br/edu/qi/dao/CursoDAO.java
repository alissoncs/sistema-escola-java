package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Curso;

@Repository
public interface CursoDAO extends JpaRepository<Curso, Long>{
}
