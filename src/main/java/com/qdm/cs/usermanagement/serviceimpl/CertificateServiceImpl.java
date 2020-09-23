package com.qdm.cs.usermanagement.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qdm.cs.usermanagement.entity.Certificate;
import com.qdm.cs.usermanagement.entity.Certification;
import com.qdm.cs.usermanagement.repository.CertificateRepository;
import com.qdm.cs.usermanagement.service.CertificateService;

@Service
@Transactional
public class CertificateServiceImpl implements CertificateService {

	@Autowired
	CertificateRepository certificateRepository;

	@Override
	public Certification addCertificateList(Certification certificate) {
		Certification certificateById = certificateRepository.findByCertificateId(certificate.getCertificateId());
		if (certificateById != null) {
			return null;
		} else {
			return certificateRepository.save(certificate);
		}
	}

	@Override
	public List<Certification> getCertificateList() {
		return certificateRepository.findAll();
	}

}
