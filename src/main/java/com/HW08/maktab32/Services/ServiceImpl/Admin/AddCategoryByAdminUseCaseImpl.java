package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.AddCategoryByAdminUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Category;
import com.HW08.maktab32.repositories.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class AddCategoryByAdminUseCaseImpl implements AddCategoryByAdminUseCase {
    @Override
    public void Add() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter category title:");
        String title = in.next();
        System.out.println("enter category description:");
        String desc = in.next();
        Category category = new Category(desc, title);

        CategoryRepository categoryRepository = CategoryRepository.getInstance();
        categoryRepository.save(category);
        System.out.println("Category Added Successfully!");
    }
}
