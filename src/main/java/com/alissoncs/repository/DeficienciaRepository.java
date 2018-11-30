package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Deficiencia;

@Repository
public interface DeficienciaRepository extends JpaRepository<Deficiencia, Long>{
}
