package com.HW08.maktab32;

import com.HW08.maktab32.config.hibernate.repositories.CrudRepository;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.entities.UserInfo;
import com.HW08.maktab32.repositories.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class ArticlePredicateTest {
    public static void main(String[] args) {
        UserRepository crudRepository = UserRepository.getInstance();
        Predicate<User> userPredicate = user -> user.getUsername().startsWith("ma");
        crudRepository.findAll(userPredicate).forEach(System.out::println);


        UserInfo userInfo = new UserInfo();
        Function<User,UserInfo> infoFunction = user -> {
            userInfo.setNatinalCode(user.getNationalCode());
            userInfo.setUsername(user.getUsername());
            return userInfo;
        };

        crudRepository.findAll(infoFunction).forEach(System.out::println);


    }
}
