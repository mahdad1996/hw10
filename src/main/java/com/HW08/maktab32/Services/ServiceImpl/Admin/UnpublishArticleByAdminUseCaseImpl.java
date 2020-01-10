package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.UnpublishArticleByAdminUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.repositories.ArticleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class UnpublishArticleByAdminUseCaseImpl implements UnpublishArticleByAdminUseCase {
    @Override
    public void unpublish(Long articleId) {
//        Session mySession = HibernateUtil.getSession();
//        mySession.beginTransaction();
        ArticleRepository articleRepository = ArticleRepository.getInstance();
        Article article =articleRepository.findById(articleId);

        article.setPublished(false);
        article.setPublishDate(null);
        article.setLastUpdateDate(new Date());
//        mySession.update(article);
//        mySession.getTransaction().commit();
        articleRepository.update(article);
        System.out.println("article Unpublished successfuly!");
    }
}
