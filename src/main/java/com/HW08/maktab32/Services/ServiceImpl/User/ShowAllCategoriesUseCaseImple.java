package com.HW08.maktab32.Services.ServiceImpl.User;

import com.HW08.maktab32.Services.Service.User.ShowAllCategoriesUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ShowAllCategoriesUseCaseImple implements ShowAllCategoriesUseCase {
    @Override
    public List<Category> showCategories() {

        Session mySession = HibernateUtil.getSession();

        System.out.println("avalable categories:");
        mySession.beginTransaction();
        Query<Category> query = mySession.createQuery("from Category");
        List<Category> categories = query.list();
        mySession.getTransaction().commit();
        return categories;
    }
}
