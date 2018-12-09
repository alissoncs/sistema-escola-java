package br.edu.qi.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.qi.dao.DeficienciaDAO;
import br.edu.qi.entidade.Deficiencia;

@Service
public class DeficienciaServiceImpl implements DeficienciaService {

	@Autowired
	private DeficienciaDAO repository;
	
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
	public Optional<Deficiencia> find(Long id) {
		return repository.findById(id);
	}

}
