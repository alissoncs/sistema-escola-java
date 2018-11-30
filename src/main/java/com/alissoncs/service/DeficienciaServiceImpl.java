package com.alissoncs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissoncs.entity.Deficiencia;
import com.alissoncs.repository.DeficienciaRepository;

@Service
public class DeficienciaServiceImpl implements DeficienciaService {

	@Autowired
	private DeficienciaRepository repository;
	
	@Override
	public Deficiencia save(Deficiencia item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Deficiencia update(Deficiencia item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Deficiencia> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Deficiencia> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Deficiencia item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Long id) {
		// TODO Auto-generated method stub
		
	}

}
