package com.qdm.cs.usermanagement.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qdm.cs.usermanagement.entity.Organization;
import com.qdm.cs.usermanagement.entity.Role;
import com.qdm.cs.usermanagement.repository.RoleRepository;
import com.qdm.cs.usermanagement.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role addRoleList(Role role) {
		System.out.println(role.getRoleId());
		Role roleById = roleRepository.findByRoleId(role.getRoleId());
		if (roleById != null) {
			return null;
		} else {
			return roleRepository.save(role);
		}
	}

	@Override
	public List<Role> getRoleList() {
		return roleRepository.findAll();
	}

}
