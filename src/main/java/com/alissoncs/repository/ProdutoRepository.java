package com.alissoncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alissoncs.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
