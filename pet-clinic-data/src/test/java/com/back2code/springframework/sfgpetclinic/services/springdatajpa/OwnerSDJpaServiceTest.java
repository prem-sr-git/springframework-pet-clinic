package com.back2code.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back2code.springframework.sfgpetclinic.model.Owner;
import com.back2code.springframework.sfgpetclinic.repositories.OwnerRepository;
import com.back2code.springframework.sfgpetclinic.repositories.PetRepository;
import com.back2code.springframework.sfgpetclinic.repositories.PetTypeRepository;

import net.bytebuddy.description.annotation.AnnotationList.Empty;
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	 private static final Long OWNER_ID = 1L;

	private static final String SMITH = "Smith";

	@Mock
	 OwnerRepository ownerRepository;
	
	 @Mock
	 PetRepository petRepository;
	 
	 @Mock
	 PetTypeRepository petTypeRepository;
	 
	 @InjectMocks
	 OwnerSDJpaService ownerSDJpaService;
	 
	 Owner returnOwner;
	
	@BeforeEach
	void setUp() throws Exception {
		
		returnOwner = Owner.builder().id(OWNER_ID).lastName(SMITH).build();
		
	}

	@Test
	void testFindById() {
		
		when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
		
		Owner owner =ownerSDJpaService.findById(OWNER_ID); 
		
		assertNotNull(owner);
	}

	@Test
	void testFindByIdNotFound() {
		
		when(ownerRepository.findById(any())).thenReturn(Optional.empty());
		
		Owner owner =ownerSDJpaService.findById(OWNER_ID);
		
		assertNull(owner);
	}

	@Test
	void testSave() {
		
		Owner ownerToSave = Owner.builder().id(1L).build();
		
		when(ownerRepository.save(any())).thenReturn(ownerToSave);
		
		Owner  savedOwner = ownerSDJpaService.save(ownerToSave);
		
		assertNotNull(savedOwner);
		
		assertEquals(OWNER_ID, savedOwner.getId());
		
		verify(ownerRepository).save(any());
	}

	@Test
	void testFindAll() {
		
		Set<Owner> returnOwnersSet = new HashSet<>();
		
		returnOwnersSet.add(Owner.builder().id(1L).build());
		
		returnOwnersSet.add(Owner.builder().id(2L).build());
		
		when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
		
		Set<Owner> owners = ownerSDJpaService.findAll(); 
		
		assertNotNull(owners);
		
		assertEquals(2, owners.size());
		
	}

	@Test
	void testDelete() {
		ownerSDJpaService.delete(returnOwner);
		
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerSDJpaService.deleteById(OWNER_ID);
		
		verify(ownerRepository).deleteById(any());
	}

	@Test
	void testFindByLastName() {
		
		Owner returnOwner = Owner.builder().id(OWNER_ID).lastName(SMITH).build();
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner ownerSmith = ownerSDJpaService.findByLastName(SMITH);
		
		assertEquals(SMITH, ownerSmith.getLastName());
		
		verify(ownerRepository).findByLastName(any());
	}

}
