package br.edu.qi.servicos;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
	public T save(T item) throws Exception;
	public T update(T item) throws Exception;
	public List<T> fetch() throws Exception;
	public List<T> fetchFilter(String param) throws Exception;
	public void delete(T item) throws Exception;
	public Optional<T> find(Long id) throws Exception;
}
