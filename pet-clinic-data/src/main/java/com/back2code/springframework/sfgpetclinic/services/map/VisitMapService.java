package com.back2code.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.back2code.springframework.sfgpetclinic.model.Visit;
import com.back2code.springframework.sfgpetclinic.services.VisitService;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit entity) {
		if (entity.getPet() == null 
				|| entity.getPet().getOwner() == null 
				|| entity.getPet().getId() == null
				|| entity.getPet().getOwner().getId() == null) {
			
			throw new RuntimeException("Invalid Visit");
			
		}
		
		return super.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit entity) {
		super.delete(entity);
	}

}
