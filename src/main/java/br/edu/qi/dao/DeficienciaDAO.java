package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Deficiencia;

@Repository
public interface DeficienciaDAO extends JpaRepository<Deficiencia, Long>{
}
