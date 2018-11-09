package com.back2code.springframework.sfgpetclinic.services;

import java.util.Set;

/**
 * Common Methods for all Service Classes
 * @author Premlatha S
 *
 * @param <T>
 * @param <ID>
 */
public interface CRUDService<T, ID> {

	public T findById(ID id);
	
	public T save(T entity);
	
	public Set<T> findAll();
	
	public void delete(T entity);
	
	public void deleteById(ID id);
}
