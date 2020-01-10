package com.HW08.maktab32.repositories;

import com.HW08.maktab32.config.hibernate.repositories.CrudRepository;
import com.HW08.maktab32.entities.Role;

public class RoleRepository extends CrudRepository<Role,Long> {
    private static RoleRepository roleRepository;

    private RoleRepository() {

    }

    public static RoleRepository getInstance() {
        if (roleRepository == null) {
            roleRepository = new RoleRepository();
        }
        return roleRepository;
    }
    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
