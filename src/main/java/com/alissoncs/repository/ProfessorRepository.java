package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
}
