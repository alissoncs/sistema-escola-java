package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Pessoa;

@Repository
public interface PessoaDAO extends JpaRepository<Pessoa, Long>{

}
