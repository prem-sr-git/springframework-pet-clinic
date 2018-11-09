package com.back2code.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.back2code.springframework.sfgpetclinic.model.Owner;
import com.back2code.springframework.sfgpetclinic.model.Pet;
import com.back2code.springframework.sfgpetclinic.services.OwnerService;
import com.back2code.springframework.sfgpetclinic.services.PetService;
import com.back2code.springframework.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService PetService;

	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.PetService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner owner) {
		super.delete(owner);
	}

	@Override
	public Owner save(Owner owner) {
		if (owner != null) {
			if (owner.getPets() != null) {
				owner.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}

					} else {
						throw new RuntimeException("Pet Type is Required");
					}
					if (pet.getId() == null) {
						Pet savedPet = PetService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(owner);
		} else {
			return null;
		}

	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
