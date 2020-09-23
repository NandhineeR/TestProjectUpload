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

import com.qdm.cs.usermanagement.entity.Specialization;
import com.qdm.cs.usermanagement.entity.SpecializationList;
import com.qdm.cs.usermanagement.response.ResponseInfo;
import com.qdm.cs.usermanagement.response.ResponseType;
import com.qdm.cs.usermanagement.service.SpecializationService;

@RestController
@RequestMapping(value = { "/specialization" })
@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
public class SpecializationController {
	@Autowired
	SpecializationService specializationService;

	@PostMapping(value = "/addSpecializationList", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addSpecializationList(@RequestBody SpecializationList specialization) {
		ResponseEntity response = null;
		try {
			SpecializationList special = specializationService.addSpecializationList(specialization);
			response = new ResponseEntity(new ResponseInfo(ResponseType.SUCCESS.getResponseMessage(),
					ResponseType.SUCCESS.getResponseCode(), "", null), HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			response = new ResponseEntity(new ResponseInfo(ResponseType.ERROR.getResponseMessage(),
					ResponseType.ERROR.getResponseCode(), "Try Again", null), HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@GetMapping(value = "/getSpecializationList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSpecializationList() {
		ResponseEntity response = null;
		try {
			List<SpecializationList> specializationList = specializationService.getSpecializationList();
			List<Object> list=new ArrayList<Object>();
			for (SpecializationList specialization : specializationList) {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("label", specialization.getLabel());
				map.put("value",specialization.getValue());
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
