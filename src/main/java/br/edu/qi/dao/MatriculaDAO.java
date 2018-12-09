package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Matricula;

@Repository
public interface MatriculaDAO extends JpaRepository<Matricula, Long>{
}
