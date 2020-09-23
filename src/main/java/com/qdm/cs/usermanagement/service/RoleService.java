package com.qdm.cs.usermanagement.service;

import java.util.List;

import com.qdm.cs.usermanagement.entity.Role;

public interface RoleService {

	Role addRoleList(Role role);

	List<Role> getRoleList();

}
