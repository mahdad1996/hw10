package com.HW08.maktab32.Services.ServiceImpl;

import com.HW08.maktab32.Services.Service.EditArticleByUserUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.Scanner;

public class EditArticleByUserUseCaseImple implements EditArticleByUserUseCase {
    @Override
    public void Edit() {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id to edit:");
        Long id = in.nextLong();
        mySession.beginTransaction();
        Article article = mySession.load(Article.class,id);
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

        mySession.update(article);
        mySession.getTransaction().commit();

    }
}
