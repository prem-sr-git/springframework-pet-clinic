package com.back2code.springframework.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.back2code.springframework.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();

	Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	T findById(ID id) {
		return map.get(id);
	}

	T save(T entity) {
		if (entity != null) {
			if (entity.getId() == null) {
				entity.setId(getNextId());
			}
		} else {
			throw new RuntimeException("Object Cannot be null");
		}
		map.put(entity.getId(), entity);
		return entity;
	}

	void deleteById(ID id) {
		map.remove(id);
	}

	void delete(T entity) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
	}

	private Long getNextId() {

		Long nextId = null;
		
		try {
			
			nextId = Collections.max(map.keySet()) + 1;
			
		} catch (NoSuchElementException e) {
			
			nextId = 1L;
			
		}
		
		return nextId;
	}
}
