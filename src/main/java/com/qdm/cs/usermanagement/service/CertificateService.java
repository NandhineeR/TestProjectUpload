package com.qdm.cs.usermanagement.service;

import java.util.List;

import com.qdm.cs.usermanagement.entity.Certificate;
import com.qdm.cs.usermanagement.entity.Certification;

public interface CertificateService {

	Certification addCertificateList(Certification certificate);

	List<Certification> getCertificateList();

}
