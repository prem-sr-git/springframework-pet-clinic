package com.back2code.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.back2code.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

	Vet findByLastName(String lastName);

}
