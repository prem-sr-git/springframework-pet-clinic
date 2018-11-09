package com.back2code.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.back2code.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
