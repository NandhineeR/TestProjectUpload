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

import com.qdm.cs.usermanagement.entity.IssuingOrgranization;
import com.qdm.cs.usermanagement.response.ResponseInfo;
import com.qdm.cs.usermanagement.response.ResponseType;
import com.qdm.cs.usermanagement.service.IssuingOrganizationService;

@RestController
@RequestMapping(value = { "/issuingorganization" })
@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
public class IssuingOrganizationController {

	@Autowired
	IssuingOrganizationService issuingOrganizationService;

	@PostMapping(value = "/addIssuingOrganization", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addIssuingOrganizationList(@RequestBody IssuingOrgranization organization) {
		ResponseEntity response = null;
		try {
			IssuingOrgranization organizationData = issuingOrganizationService.addIssuingOrganizationList(organization);
			response = new ResponseEntity(new ResponseInfo(ResponseType.SUCCESS.getResponseMessage(),
					ResponseType.SUCCESS.getResponseCode(), "", null), HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			response = new ResponseEntity(new ResponseInfo(ResponseType.ERROR.getResponseMessage(),
					ResponseType.ERROR.getResponseCode(), "Try Again", null), HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@GetMapping(value = "/getIssuingOrganizationList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getIssuingOrganizationList() {
		ResponseEntity response = null;
		try {
			List<IssuingOrgranization> organizationList = issuingOrganizationService.getIssuingOrganizationList();
			List<Object> list = new ArrayList<Object>();
			for (IssuingOrgranization organization : organizationList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("label", organization.getOrganizationName());
				map.put("value", organization.getOrganizationId());
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
