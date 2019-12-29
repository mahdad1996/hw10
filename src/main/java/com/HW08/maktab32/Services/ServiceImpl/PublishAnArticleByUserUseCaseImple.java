package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.PublishAnArticleByUserUseCase;
import com.HW08.maktab32.Services.Service.ShowUserArticlesUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class PublishAnArticleByUserUseCaseImple implements PublishAnArticleByUserUseCase {
    @Override
    public void Publish(Long id) {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();
        mySession.beginTransaction();
        Article article = mySession.load(Article.class,id);
        article.setPublished(true);
        article.setPublishDate(new Date());
        article.setLastUpdateDate(new Date());
        mySession.update(article);
        mySession.getTransaction().commit();
        System.out.println("article published successfuly!");

    }
}
