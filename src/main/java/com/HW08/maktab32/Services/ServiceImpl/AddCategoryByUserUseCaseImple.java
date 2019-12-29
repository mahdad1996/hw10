package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.AddCategoryByUserUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class AddCategoryByUserUseCaseImple implements AddCategoryByUserUseCase {
    @Override
    public void Add() {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();
        Scanner in = new Scanner(System.in);
        System.out.println("enter category title:");
        String title = in.next();
        System.out.println("enter category description:");
        String desc = in.next();
        Category category = new Category(desc, title);

        mySession.save(category);
        mySession.beginTransaction().commit();
    }
}
