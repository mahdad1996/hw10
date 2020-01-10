package com.HW08.maktab32.Services.ServiceImpl.User;

import com.HW08.maktab32.Services.Service.User.LoginUserUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.shared.AuthenticationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Scanner;

public class LoginUserUseCaseImple implements LoginUserUseCase {
    @Override
    public void login() {

        Session mySession = HibernateUtil.getSession();
        Scanner input = new Scanner(System.in);
        if(AuthenticationService.getInstance().getLoginUser()==null){
            mySession.beginTransaction();
            System.out.println("enter username:");
            String username = input.next();
            System.out.println("enter password:");
            String password = input.next();

            Query<User> query = mySession.createQuery("from User where username=:username AND password=:password");
            query.setParameter("username",username);
            query.setParameter("password",password);
            User user;
            user=query.uniqueResult();

            mySession.getTransaction().commit();
            if(user!=null){
                System.out.println("logged in as "+ user.getUsername());
                AuthenticationService.getInstance().setLoginUser(user);
            }
        }
        else System.out.println("Log out First!");
    }
}
