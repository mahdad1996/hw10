package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.ShowAllArticlesToAdminUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.repositories.ArticleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ShowAllArticlesToAdminUseCaseImpl implements ShowAllArticlesToAdminUseCase {
    @Override
    public void showAllArticles() {

//        Session mySession = HibernateUtil.getSession();
//        mySession.beginTransaction();
//        Query<Article> query = mySession.createQuery("from Article");
        ArticleRepository articleRepository = ArticleRepository.getInstance();
        List<Article> articles ;
        articles = articleRepository.findAll();
        //mySession.getTransaction().commit();
        articles.forEach(System.out::println);
    }
}
