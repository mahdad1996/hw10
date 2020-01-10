package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.AddNewRoleByAdminUseCase;
import com.HW08.maktab32.entities.Role;
import com.HW08.maktab32.repositories.RoleRepository;

public class AddNewRoleByAdminUseCaseImpl implements AddNewRoleByAdminUseCase {
    @Override
    public void Add(Role role) {
        RoleRepository roleRepository = RoleRepository.getInstance();
        roleRepository.save(role);
    }
}
