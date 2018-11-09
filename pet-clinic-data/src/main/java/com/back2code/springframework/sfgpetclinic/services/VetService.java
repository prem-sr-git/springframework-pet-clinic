package com.back2code.springframework.sfgpetclinic.services;

import com.back2code.springframework.sfgpetclinic.model.Vet;

public interface VetService extends CRUDService<Vet, Long> {

	Vet findByLastName(String lastName);

}
