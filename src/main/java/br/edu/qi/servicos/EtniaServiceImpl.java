package br.edu.qi.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.qi.dao.EtniaDAO;
import br.edu.qi.entidade.Etnia;
import br.edu.qi.entidade.Genero;

@Service
public class EtniaServiceImpl implements EtniaService {

	@Autowired
	private EtniaDAO repository;
	
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
