package com.alissoncs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alissoncs.entity.Deficiencia;

@Service
public class DeficienciaServiceImpl implements DeficienciaService {

	@Override
	public Deficiencia save(Deficiencia item) throws Exception {
		item.setId(Long.valueOf(1));
		return item;
	}

	@Override
	public Deficiencia update(Deficiencia item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deficiencia> fetch() {
		// TODO Auto-generated method stub
		return null;
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
