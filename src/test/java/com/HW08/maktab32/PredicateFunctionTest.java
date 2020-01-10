package com.HW08.maktab32;

import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.entities.UserInfo;
import com.HW08.maktab32.repositories.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class PredicateFunctionTest {

    @Test
    void main() {
        UserRepository crudRepository = UserRepository.getInstance();
//        Predicate<User> userPredicate = user -> user.getUsername().startsWith("ma");
//        crudRepository.findAll(userPredicate);

        UserInfo userInfo = new UserInfo();

        Function<User,UserInfo> infoFunction = user -> {
            userInfo.setNatinalCode(user.getNationalCode());
            userInfo.setUsername(user.getUsername());
            return userInfo;
        };

        crudRepository.findAll(infoFunction);
    }
}