package com.alissoncs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissoncs.entity.Religiao;
import com.alissoncs.repository.ReligiaoRepository;

@Service
public class ReligiaoServiceImpl implements ReligiaoService {

	@Autowired
	private ReligiaoRepository repository;
	
	@Override
	public Religiao save(Religiao item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Religiao update(Religiao item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Religiao> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Religiao> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Religiao item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Religiao> find(Long id) {
		return repository.findById(id);
	}

}
