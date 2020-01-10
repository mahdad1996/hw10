package com.HW08.maktab32.Services.ServiceImpl.Admin;

import com.HW08.maktab32.Services.Service.Admin.DeleteArticleByAdminUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.repositories.ArticleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class DeleteArticleByAdminUseCaseImpl implements DeleteArticleByAdminUseCase {
    @Override
    public void Delete(Long articleId) {
       // Session session = HibernateUtil.getSession();

       // session.beginTransaction();
      //  Article article = session.load(Article.class,articleId);
        ArticleRepository articleRepository = ArticleRepository.getInstance();
        Article article = articleRepository.findById(articleId);
        articleRepository.remove(article);
//        session.remove(article);
//        session.getTransaction().commit();
        System.out.println("article deleted successfuly!");
    }
}
