package com.back2code.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.back2code.springframework.sfgpetclinic.model.Owner;
import com.back2code.springframework.sfgpetclinic.repositories.OwnerRepository;
import com.back2code.springframework.sfgpetclinic.repositories.PetRepository;
import com.back2code.springframework.sfgpetclinic.repositories.PetTypeRepository;
import com.back2code.springframework.sfgpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findById(Long id) {

		return ownerRepository.findById(id).orElse(null);

	}

	@Override
	public Owner save(Owner entity) {
		return ownerRepository.save(entity);
	}

	@Override
	public Set<Owner> findAll() {

		Set<Owner> owners = new HashSet<>();

		ownerRepository.findAll().forEach(owners::add);

		return owners;
	}

	@Override
	public void delete(Owner entity) {
		ownerRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);

	}

	@Override
	public Owner findByLastName(String lastName) {

		return ownerRepository.findByLastName(lastName);
	}

}
