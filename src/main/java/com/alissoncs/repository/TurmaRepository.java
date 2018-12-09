package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Turma;
@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
}
