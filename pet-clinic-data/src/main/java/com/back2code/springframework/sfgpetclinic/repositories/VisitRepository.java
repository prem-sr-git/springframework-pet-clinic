package com.back2code.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.back2code.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
