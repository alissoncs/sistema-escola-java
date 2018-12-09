package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long>{
}
