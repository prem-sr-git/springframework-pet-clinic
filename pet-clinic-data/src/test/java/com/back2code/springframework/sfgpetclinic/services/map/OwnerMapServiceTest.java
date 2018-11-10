package com.back2code.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.back2code.springframework.sfgpetclinic.model.Owner;

class OwnerMapServiceTest {
	
	OwnerMapService OwnerMapService;
	final Long ownerId = 1L;
	final String lastName = "Smith";

	@BeforeEach
	void setUp() throws Exception {
		OwnerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService()) ;
		OwnerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = OwnerMapService.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = OwnerMapService.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testDeleteByIdLong() {
		OwnerMapService.deleteById(ownerId);
		assertEquals(0, OwnerMapService.findAll().size());
	}

	@Test
	void testDeleteOwner() {
		OwnerMapService.delete(OwnerMapService.findById(ownerId));
		assertEquals(0, OwnerMapService.findAll().size());
	}

	@Test
	void testSaveOwner() {
		Long owner2Id = 2L;
		Owner owner2 =  Owner.builder().id(owner2Id).build();
		Owner savedOwner = OwnerMapService.save(owner2);
		assertEquals(owner2Id, savedOwner.getId());
	}
	
	@Test
	void testSaveOwnerNoId() {
		Owner savedOwner = OwnerMapService.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testFindByLastName() {
		Owner owner = OwnerMapService.findByLastName(lastName);
		assertNotNull(owner);
		assertEquals(ownerId, owner.getId());
		assertEquals(lastName, owner.getLastName());

	}

}
