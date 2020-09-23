package com.qdm.cs.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qdm.cs.usermanagement.entity.Certification;

@Repository
public interface CertificateRepository extends JpaRepository<Certification, Integer> {

	Certification findByCertificateId(int certificateId);

}
