package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
}
