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

import com.qdm.cs.usermanagement.entity.Organization;
import com.qdm.cs.usermanagement.entity.Role;
import com.qdm.cs.usermanagement.response.ResponseInfo;
import com.qdm.cs.usermanagement.response.ResponseType;
import com.qdm.cs.usermanagement.service.CareGiverService;
import com.qdm.cs.usermanagement.service.OrganizationService;
import com.qdm.cs.usermanagement.service.RoleService;

@RestController
@RequestMapping(value = { "/role" })
@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
public class RoleController {

	@Autowired
	CareGiverService careGiverService;

	@Autowired
	RoleService roleService;

	@PostMapping(value = "/addRole", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addRoleList(@RequestBody Role role) {
		ResponseEntity response = null;
		try {
			Role roleData = roleService.addRoleList(role);
			response = new ResponseEntity(new ResponseInfo(ResponseType.SUCCESS.getResponseMessage(),
					ResponseType.SUCCESS.getResponseCode(), "", null), HttpStatus.CREATED);
			return response;
		} catch (Exception e) {
			response = new ResponseEntity(new ResponseInfo(ResponseType.ERROR.getResponseMessage(),
					ResponseType.ERROR.getResponseCode(), "Try Again", null), HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@GetMapping(value = "/getRoleList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getRoleList() {
		ResponseEntity response = null;
		try {
			List<Role> roleList = roleService.getRoleList();
			List<Object> list = new ArrayList<Object>();
			for (Role role : roleList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("label", role.getRoleName());
				map.put("value", role.getRoleId());
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
