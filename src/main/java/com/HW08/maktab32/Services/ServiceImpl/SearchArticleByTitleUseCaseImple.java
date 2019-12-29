package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.SearchArticleByTitleUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class SearchArticleByTitleUseCaseImple implements SearchArticleByTitleUseCase {
    @Override
    public Article search(String title) {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();
        Query<Article> query = mySession.createQuery("from Article where title=:title");
        query.setParameter("title",title);
        Article article;
        article=query.uniqueResult();

        mySession.getTransaction().commit();
        if(article!=null){
            return article;
        }

        return null;
    }
}
