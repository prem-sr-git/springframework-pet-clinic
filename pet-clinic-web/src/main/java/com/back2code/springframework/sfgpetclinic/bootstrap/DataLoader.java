package com.back2code.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.back2code.springframework.sfgpetclinic.model.Owner;
import com.back2code.springframework.sfgpetclinic.model.Pet;
import com.back2code.springframework.sfgpetclinic.model.PetType;
import com.back2code.springframework.sfgpetclinic.model.Speciality;
import com.back2code.springframework.sfgpetclinic.model.Vet;
import com.back2code.springframework.sfgpetclinic.model.Visit;
import com.back2code.springframework.sfgpetclinic.services.OwnerService;
import com.back2code.springframework.sfgpetclinic.services.PetService;
import com.back2code.springframework.sfgpetclinic.services.PetTypeService;
import com.back2code.springframework.sfgpetclinic.services.SpecialityService;
import com.back2code.springframework.sfgpetclinic.services.VetService;
import com.back2code.springframework.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetService petService,
			PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService ) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();
		
		if (count == 0) {
			loadData();

		}
	}

	private void loadData() {
		PetType petTypeDog = new PetType();
		petTypeDog.setName("Dog");
		PetType savedDogType = petTypeService.save(petTypeDog);

		PetType petTypeCat = new PetType();
		petTypeCat.setName("Cat");
		PetType savedCatType = petTypeService.save(petTypeCat);

		Visit mimisVisit = new Visit();
		mimisVisit.setDate(LocalDate.now());
		mimisVisit.setDescription("Sneezy Kitty");
		
		Pet jimsPet = new Pet();
		jimsPet.setPetType(savedDogType);
		jimsPet.setName("Tiger");
		jimsPet.setBirthDate(LocalDate.now());

		Pet maxsPet = new Pet();
		maxsPet.setPetType(savedCatType);
		maxsPet.setName("Mimi");
		maxsPet.setBirthDate(LocalDate.now());
		maxsPet.addVisit(mimisVisit);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Jim");
		owner1.setLastName("Boree");
		owner1.setAddress("123 Mckee rd");
		owner1.setCity("San Jose");
		owner1.setTelephone("408-414-8722");
		owner1.addPet(jimsPet);

		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Maxwell");
		owner2.setLastName("Eaton");
		owner2.setAddress("987 Fremont Ave");
		owner2.setCity("Sunnyvale");
		owner2.setTelephone("408-760-4123");
		owner2.addPet(maxsPet);

		ownerService.save(owner2);

		System.out.println("Loaded Owners.....");
		
		
		Speciality radiology = new Speciality();
		radiology.setFieldName("Radiology");
		radiology = specialityService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setFieldName("Surgery");
		surgery = specialityService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setFieldName("Dentistry");
		dentistry = specialityService.save(dentistry);

		Vet vet1 = new Vet();
		vet1.setFirstName("Dodge");
		vet1.setLastName("Momo");

		vet1.getSpecialities().add(surgery);
		vet1.getSpecialities().add(dentistry);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Lulu");
		vet2.setLastName("Lemon");

		vet2.getSpecialities().add(radiology);

		vetService.save(vet2);

		System.out.println("Loaded Vets.....");
	}

}
