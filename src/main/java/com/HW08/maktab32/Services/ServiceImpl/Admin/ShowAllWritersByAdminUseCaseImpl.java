package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.ShowAllWritersByAdminUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ShowAllWritersByAdminUseCaseImpl implements ShowAllWritersByAdminUseCase {
    @Override
    public void ShowWriters() {

        Session mySession = HibernateUtil.getSession();
        mySession.beginTransaction();
        Query<User> query = mySession.createQuery("from user_role where rid=:rid ");
        query.setParameter("rid",2L);
        List<User> users ;
        users = query.list();
        mySession.getTransaction().commit();
        users.forEach(System.out::println);
    }
}
