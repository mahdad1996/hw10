package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.ShowUserArticlesUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.shared.AuthenticationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ShowUserArticlesUseCaseImple implements ShowUserArticlesUseCase {
    @Override
    public List<Article> showArticles() {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();
        mySession.beginTransaction();
        Query<Article> query = mySession.createQuery("from Article where user_id=:id");
        query.setParameter("id", AuthenticationService.getInstance().getLoginUser().getId());
        List<Article> articles;
        articles = query.list();
        mySession.getTransaction().commit();
        return articles;
    }
}
