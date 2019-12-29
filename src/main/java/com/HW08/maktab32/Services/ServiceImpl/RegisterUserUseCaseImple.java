package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.RegisterUserUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class RegisterUserUseCaseImple implements RegisterUserUseCase {
    @Override
    public Long Register() {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();
        Scanner input=new Scanner(System.in);
        mySession.beginTransaction();
        System.out.println("Enter Username:");
        String username = input.next();
        System.out.println("Enter National Code:");
        String nCode = input.next();
        System.out.println("Enter birthday!");
        String birth = input.next();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
        Date birthday=null;
        try {
            birthday =format.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(username,nCode,nCode,birthday);
        Long id = (Long)  mySession.save(user);
        mySession.getTransaction().commit();
        return id;
    }
}
