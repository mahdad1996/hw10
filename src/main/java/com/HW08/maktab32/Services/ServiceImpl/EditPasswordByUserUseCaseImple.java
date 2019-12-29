package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.EditPasswordByUserUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.shared.AuthenticationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class EditPasswordByUserUseCaseImple implements EditPasswordByUserUseCase {
    @Override
    public void editPassword() {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new password:");
        String pass = in.next();
        mySession.beginTransaction();
        Long id = AuthenticationService.getInstance().getLoginUser().getId();
        User user = mySession.load(User.class,id);
        user.setPassword(pass);
        mySession.update(user);
        mySession.getTransaction().commit();
    }
}
