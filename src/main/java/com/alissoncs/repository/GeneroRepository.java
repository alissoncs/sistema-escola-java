package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{
}
