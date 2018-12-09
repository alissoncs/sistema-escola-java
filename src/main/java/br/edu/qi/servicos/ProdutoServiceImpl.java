package br.edu.qi.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.qi.dao.ProdutoDAO;
import br.edu.qi.entidade.Genero;
import br.edu.qi.entidade.Produto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoDAO repository;
	
	@Override
	public Produto save(Produto item) throws Exception {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public Produto update(Produto item) {
		repository.saveAndFlush(item);
		return item;
	}

	@Override
	public List<Produto> fetch() {
		return repository.findAll();
	}

	@Override
	public List<Produto> fetchFilter(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Produto item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Produto> find(Long id) {
		return repository.findById(id);
	}

}
