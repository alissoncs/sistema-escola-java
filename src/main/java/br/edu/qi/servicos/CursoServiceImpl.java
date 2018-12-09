package br.edu.qi.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.qi.dao.CursoDAO;
import br.edu.qi.entidade.Curso;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoDAO repository;
	
	@Override
	public Curso save(Curso item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Curso update(Curso item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Curso> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Curso> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Curso item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Curso> find(Long id) {
		return repository.findById(id);
	}

}
