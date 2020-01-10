package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.PublishArticleByAdminUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.repositories.ArticleRepository;
import com.HW08.maktab32.repositories.RoleRepository;
import com.HW08.maktab32.shared.AuthenticationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class PublishArticleByAdminUseCaseImpl implements PublishArticleByAdminUseCase {
    @Override
    public void publish(Long articleId) {
//        Session mySession = HibernateUtil.getSession();
//        mySession.beginTransaction();
        ArticleRepository articleRepository = ArticleRepository.getInstance();

        Article article = articleRepository.findById(articleId);
        article.setPublished(true);
        article.setPublishDate(new Date());
        article.setLastUpdateDate(new Date());
//        mySession.update(article);
//        mySession.getTransaction().commit();
        articleRepository.update(article);
        System.out.println("article published successfuly!");
    }
}
