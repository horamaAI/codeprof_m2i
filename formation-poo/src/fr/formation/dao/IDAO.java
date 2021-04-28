package fr.formation.dao;

import java.util.List;

public interface IDAO<T> {
	public T save(T entity);
	public List<T> findAll();
	public T findById(int id);
	public boolean deleteById(int id);
}