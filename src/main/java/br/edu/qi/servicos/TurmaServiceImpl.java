package br.edu.qi.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.qi.dao.TurmaDAO;
import br.edu.qi.entidade.Turma;

@Service
public class TurmaServiceImpl implements TurmaService {

	@Autowired
	private TurmaDAO repository;
	
	@Override
	public Turma save(Turma item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Turma update(Turma item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Turma> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Turma> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Turma item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Turma> find(Long id) {
		return repository.findById(id);
	}

}
