package com.HW08.maktab32.Services.ServiceImpl.User;

import com.HW08.maktab32.Services.Service.User.EditArticleByUserUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.repositories.ArticleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.Scanner;

public class EditArticleByUserUseCaseImple implements EditArticleByUserUseCase {
    @Override
    public void Edit() {
        //Session mySession = HibernateUtil.getSession();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id to edit:");
        Long id = in.nextLong();
       // mySession.beginTransaction();
        ArticleRepository articleRepository = ArticleRepository.getInstance();
        Article article = articleRepository.findById(id);
        System.out.println(article);
        System.out.println("enter title:");
        String title = in.next();
        System.out.println("enter brief:");
        String brief = in.next();
        System.out.println("enter content:");
        String content = in.next();
        System.out.println("is published:");
        int isPublished = in.nextInt();
        article.setTitle(title);
        article.setBrief(brief);
        article.setContent(content);
        if(isPublished==0)article.setPublished(false);
        else {
            article.setPublished(true);
            article.setPublishDate(new Date());

        }
        article.setLastUpdateDate(new Date());
        articleRepository.update(article);
//        mySession.update(article);
//        mySession.getTransaction().commit();

    }
}
