package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
}
