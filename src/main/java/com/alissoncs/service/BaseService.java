package com.alissoncs.service;

import java.util.List;

public interface BaseService<T> {
	public T save(T item) throws Exception;
	public T update(T item) throws Exception;
	public List<T> fetch() throws Exception;
	public List<T> fetchFilter(String param) throws Exception;
	public void delete(T item) throws Exception;
	public void find(Long id) throws Exception;
}
