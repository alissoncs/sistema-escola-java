package com.alissoncs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissoncs.entity.Professor;
import com.alissoncs.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository repository;
	
	@Override
	public Professor save(Professor item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Professor update(Professor item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Professor> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Professor> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Professor item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Professor> find(Long id) {
		return repository.findById(id);
	}

}
