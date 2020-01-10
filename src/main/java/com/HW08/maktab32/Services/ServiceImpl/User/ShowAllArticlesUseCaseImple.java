package com.HW08.maktab32.Services.ServiceImpl.User;

import com.HW08.maktab32.Services.Service.User.ShowAllArticlesUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ShowAllArticlesUseCaseImple implements ShowAllArticlesUseCase {
    @Override
    public List<Article> showAll() {

        Session mySession = HibernateUtil.getSession();
        mySession.beginTransaction();
        Query<Article> query = mySession.createQuery("from Article");
        List<Article> articles ;
        articles = query.list();
        mySession.getTransaction().commit();
        return articles;
    }
}
