package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.ShowAllArticlesUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ShowAllArticlesUseCaseImple implements ShowAllArticlesUseCase {
    @Override
    public List<Article> showAll() {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();
        mySession.beginTransaction();
        Query<Article> query = mySession.createQuery("from Article");
        List<Article> articles ;
        articles = query.list();
        mySession.getTransaction().commit();
        return articles;
    }
}
