package br.edu.qi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.qi.entidade.Religiao;

@Repository
public interface ReligiaoDAO extends JpaRepository<Religiao, Long>{
}
