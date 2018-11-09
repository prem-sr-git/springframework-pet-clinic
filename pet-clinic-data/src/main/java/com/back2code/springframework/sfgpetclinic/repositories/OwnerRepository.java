package com.back2code.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.back2code.springframework.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastName);
}
