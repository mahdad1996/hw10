package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.ShowAllRolesByAdminUseCase;
import com.HW08.maktab32.entities.Role;
import com.HW08.maktab32.repositories.RoleRepository;

import java.util.List;

public class ShowAllRolesByAdminUseCaseImple implements ShowAllRolesByAdminUseCase {
    @Override
    public void ShowRoles() {
        RoleRepository roleRepository = RoleRepository.getInstance();
        List<Role> roles =  roleRepository.findAll();
        roles.forEach(System.out::println);
    }
}
