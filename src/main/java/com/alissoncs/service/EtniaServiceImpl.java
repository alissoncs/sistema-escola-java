package com.alissoncs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissoncs.entity.Etnia;
import com.alissoncs.entity.Genero;
import com.alissoncs.repository.EtniaRepository;

@Service
public class EtniaServiceImpl implements EtniaService {

	@Autowired
	private EtniaRepository repository;
	
	@Override
	public Etnia save(Etnia item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Etnia update(Etnia item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Etnia> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Etnia> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Etnia item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Etnia> find(Long id) {
		return repository.findById(id);
	}

}
