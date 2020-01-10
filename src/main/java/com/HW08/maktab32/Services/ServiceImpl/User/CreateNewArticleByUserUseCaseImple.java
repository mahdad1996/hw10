package com.HW08.maktab32.Services.ServiceImpl.User;

import com.HW08.maktab32.Services.Service.User.AddCategoryByUserUseCase;
import com.HW08.maktab32.Services.Service.User.CreateNewArticleByUserUseCase;
import com.HW08.maktab32.Services.Service.User.ShowAllCategoriesUseCase;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.entities.Category;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.repositories.ArticleRepository;
import com.HW08.maktab32.repositories.CategoryRepository;
import com.HW08.maktab32.shared.AuthenticationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CreateNewArticleByUserUseCaseImple implements CreateNewArticleByUserUseCase {
    @Override
    public void Add() {

        //Session mySession = HibernateUtil.getSession();
        Scanner in = new Scanner(System.in);
        List<Category> categories = new ArrayList<>();
        ShowAllCategoriesUseCase showAllCategoriesUseCase = new ShowAllCategoriesUseCaseImple();
        categories = showAllCategoriesUseCase.showCategories();
        categories.forEach(System.out::println);
        Long c=-1L;
        System.out.println("enter id to choose!");
        c=in.nextLong();
        //mySession.beginTransaction();
        CategoryRepository categoryRepository = CategoryRepository.getInstance();
        Category category = categoryRepository.findById(c);

        System.out.println("enter title:");
        String title = in.next();
        System.out.println("enter brief:");
        String brief = in.next();
        System.out.println("enter content:");
        String content = in.next();

        System.out.println("is published:");

        boolean isp = in.nextBoolean();
        Date publishDate=null;
        if(isp)
            publishDate = new Date();


        User u = AuthenticationService.getInstance().getLoginUser();
        Article article = new Article(title,brief,content,new Date(),new Date(),publishDate,isp,u,category );
        ArticleRepository articleRepository = ArticleRepository.getInstance();
        articleRepository.save(article);
//        mySession.save(article);
//        mySession.getTransaction().commit();
    }
}
