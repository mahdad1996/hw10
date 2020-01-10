package com.HW08.maktab32.Services.Service.Admin;

import com.HW08.maktab32.entities.Role;
import com.HW08.maktab32.entities.User;

public interface EditUsersRoleByAdminUseCase {
    void Edit(Long userId, Long roleId);
}
