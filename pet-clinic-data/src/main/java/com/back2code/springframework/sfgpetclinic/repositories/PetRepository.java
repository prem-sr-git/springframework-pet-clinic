package com.back2code.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.back2code.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
