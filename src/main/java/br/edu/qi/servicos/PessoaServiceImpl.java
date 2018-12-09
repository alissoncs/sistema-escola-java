package br.edu.qi.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.qi.dao.PessoaDAO;
import br.edu.qi.entidade.Pessoa;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaDAO repository;
	
	@Override
	public Pessoa save(Pessoa item) throws Exception {
		return repository.saveAndFlush(item);
	}

	@Override
	public Pessoa update(Pessoa item) throws Exception {
		return repository.saveAndFlush(item);
	}

	@Override
	public List<Pessoa> fetch() throws Exception {
		return repository.findAll();
	}

	@Override
	public List<Pessoa> fetchFilter(String param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Pessoa item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Pessoa> find(Long id) throws Exception {
		return repository.findById(id);
	}

}
