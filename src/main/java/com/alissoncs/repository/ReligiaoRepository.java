package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Religiao;

@Repository
public interface ReligiaoRepository extends JpaRepository<Religiao, Long>{
}
