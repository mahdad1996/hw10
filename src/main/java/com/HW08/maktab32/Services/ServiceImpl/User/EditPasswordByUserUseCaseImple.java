package com.HW08.maktab32.Services.ServiceImpl.User;

import com.HW08.maktab32.Services.Service.User.EditPasswordByUserUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.repositories.UserRepository;
import com.HW08.maktab32.shared.AuthenticationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class EditPasswordByUserUseCaseImple implements EditPasswordByUserUseCase {
    @Override
    public void editPassword() {

        //Session mySession = HibernateUtil.getSession();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new password:");
        String pass = in.next();
       // mySession.beginTransaction();
        Long id = AuthenticationService.getInstance().getLoginUser().getId();
        UserRepository userRepository = UserRepository.getInstance();
        User user = userRepository.findById(id);
        user.setPassword(pass);
        userRepository.update(user);
//        mySession.update(user);
//        mySession.getTransaction().commit();
    }
}
