package com.alissoncs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissoncs.entity.Aluno;
import com.alissoncs.entity.Genero;
import com.alissoncs.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	@Override
	public Aluno save(Aluno item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Aluno update(Aluno item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Aluno> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Aluno> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Aluno item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Aluno> find(Long id) {
		return repository.findById(id);
	}

}
