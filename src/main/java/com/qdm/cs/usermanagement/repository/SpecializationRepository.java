package com.qdm.cs.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qdm.cs.usermanagement.entity.SpecializationList;

@Repository
public interface SpecializationRepository extends JpaRepository<SpecializationList, Integer> {

	SpecializationList findByValue(int value);

}
