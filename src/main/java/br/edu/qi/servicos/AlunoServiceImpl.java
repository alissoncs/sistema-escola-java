package br.edu.qi.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.qi.dao.AlunoDAO;
import br.edu.qi.entidade.Aluno;
import br.edu.qi.entidade.Genero;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoDAO repository;
	
	@Override
	public Aluno save(Aluno item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Aluno update(Aluno item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Aluno> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Aluno> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Aluno item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Aluno> find(Long id) {
		return repository.findById(id);
	}

}
