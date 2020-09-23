package com.qdm.cs.usermanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qdm.cs.usermanagement.entity.Certificate;
import com.qdm.cs.usermanagement.entity.Certification;
import com.qdm.cs.usermanagement.response.ResponseInfo;
import com.qdm.cs.usermanagement.response.ResponseType;
import com.qdm.cs.usermanagement.service.CareGiverService;
import com.qdm.cs.usermanagement.service.CertificateService;

@RestController
@RequestMapping(value = { "/certificate" })
@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
public class CertificateController {
	@Autowired
	CareGiverService careGiverService;

	@Autowired
	CertificateService certificateService;

	@PostMapping(value = "/addCertificate", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addCertificateList(@RequestBody Certification Certificate) {
		ResponseEntity response = null;
		try {
			Certification CertificateData = certificateService.addCertificateList(Certificate);
			response = new ResponseEntity(new ResponseInfo(ResponseType.SUCCESS.getResponseMessage(),
					ResponseType.SUCCESS.getResponseCode(), "", null), HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			response = new ResponseEntity(new ResponseInfo(ResponseType.ERROR.getResponseMessage(),
					ResponseType.ERROR.getResponseCode(), "Try Again", null), HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@GetMapping(value = "/getCertificateList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCertificateList() {
		ResponseEntity response = null;
		try {
			List<Certification> CertificateList = certificateService.getCertificateList();
			List<Object> list = new ArrayList<Object>();
			for (Certification Certificate : CertificateList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("label", Certificate.getCertificateName());
				map.put("value", Certificate.getCertificateId());
				list.add(map);
			}
			response = new ResponseEntity(new ResponseInfo(ResponseType.SUCCESS.getResponseMessage(),
					ResponseType.SUCCESS.getResponseCode(), "", list), HttpStatus.OK);
			return response;
		} catch (Exception e) {
			response = new ResponseEntity(new ResponseInfo(ResponseType.ERROR.getResponseMessage(),
					ResponseType.ERROR.getResponseCode(), "Try Again", null), HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}
}
