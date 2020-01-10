package com.HW08.maktab32.repositories;

import com.HW08.maktab32.config.hibernate.repositories.CrudRepository;
import com.HW08.maktab32.entities.Role;
import com.HW08.maktab32.entities.User;

public class UserRepository extends CrudRepository<User,Long> {
    private static UserRepository userRepository;

    private UserRepository() {

    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
