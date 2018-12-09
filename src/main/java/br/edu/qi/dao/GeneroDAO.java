package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Genero;

@Repository
public interface GeneroDAO extends JpaRepository<Genero, Long>{
}
