package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Etnia;

@Repository
public interface EtniaRepository extends JpaRepository<Etnia, Long>{
}
