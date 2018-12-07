package com.alissoncs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissoncs.entity.Genero;
import com.alissoncs.repository.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroRepository repository;
	
	@Override
	public Genero save(Genero item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Genero update(Genero item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Genero> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Genero> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Genero item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Genero> find(Long id) {
		return repository.findById(id);
	}

}
