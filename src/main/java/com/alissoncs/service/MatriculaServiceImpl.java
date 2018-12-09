package com.alissoncs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissoncs.entity.Matricula;
import com.alissoncs.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaRepository repository;
	
	@Override
	public Matricula save(Matricula item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Matricula update(Matricula item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Matricula> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Matricula> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Matricula item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Matricula> find(Long id) {
		return repository.findById(id);
	}

}
