package com.back2code.springframework.sfgpetclinic.services;

import com.back2code.springframework.sfgpetclinic.model.Owner;

public interface OwnerService  extends CRUDService<Owner, Long>{
	
	Owner findByLastName(String lastName);

}
