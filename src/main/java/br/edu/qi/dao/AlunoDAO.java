package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Aluno;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Long>{
}
