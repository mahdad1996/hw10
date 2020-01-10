package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.EditUsersRoleByAdminUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Role;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.repositories.RoleRepository;
import com.HW08.maktab32.repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EditUsersRoleByAdminUseCaseImple implements EditUsersRoleByAdminUseCase {

    @Override
    public void Edit(Long userId, Long roleId) {

        Session mySession = HibernateUtil.getSession();
        mySession.beginTransaction();
        UserRepository userRepository = UserRepository.getInstance();
        User user = userRepository.findById(userId);
        RoleRepository roleRepository = RoleRepository.getInstance();
        List<Role> roles = new ArrayList<>();
        Query<Role> roleQuery = mySession.createQuery("from Role where id=:id");
        roleQuery.setParameter("id",roleId);
        roles = roleQuery.list();
        user.setRoles(roles);
        userRepository.update(user);
//        mySession.update(user);
//        mySession.getTransaction().commit();

    }
}
