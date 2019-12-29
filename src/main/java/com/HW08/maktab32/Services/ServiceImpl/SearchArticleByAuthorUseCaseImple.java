package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.SearchArticleByAuthorUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class SearchArticleByAuthorUseCaseImple implements SearchArticleByAuthorUseCase {
    @Override
    public List<Article> search(String authorName) {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();

        Query<User> getUser = mySession.createQuery("from User where username=:username");
        getUser.setParameter("username",authorName);

        User user = getUser.uniqueResult();
        Query<Article> getArticle = mySession.createQuery("from Article where user_id=:user_id");
        getArticle.setParameter("user_id",user.getId());
        List<Article> articles = getArticle.list();
        mySession.beginTransaction().commit();
        return articles;

    }
}
