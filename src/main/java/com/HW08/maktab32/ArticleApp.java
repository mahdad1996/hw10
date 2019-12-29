package com.HW08.maktab32;

import com.HW08.maktab32.Services.Service.*;
import com.HW08.maktab32.Services.ServiceImpl.*;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.entities.Category;
import com.HW08.maktab32.entities.User;
import com.HW08.maktab32.shared.AuthenticationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ArticleApp {

    public static void main(String[] args) {
        SessionFactory session = HibernateUtil.getSession();
        Session mySession = session.openSession();

        boolean condition = true;
        Scanner in= new Scanner(System.in);
        while (condition){
                if(AuthenticationService.getInstance().getLoginUser()==null){
                    int msgCode=0;
                    System.out.println("what do you want? 1.register | 2.login | 3.Show All Articles");
                    Scanner input = new Scanner(System.in);
                    msgCode = input.nextInt();
                    switch (msgCode){
                        case 1:{

                            RegisterUserUseCase registerUserUseCase = new RegisterUserUseCaseImple();
                            registerUserUseCase.Register();

                        }
                        case 2:{
                            LoginUserUseCase loginUserUseCase = new LoginUserUseCaseImple();
                            loginUserUseCase.login();
                            break;

                        }
                        case 3:{
                            ShowAllArticlesUseCase showAllArticlesUseCase = new ShowAllArticlesUseCaseImple();
                            List<Article>articles = new ArrayList<>();
                            articles=showAllArticlesUseCase.showAll();
                            articles.forEach(System.out::println);
                            break;
                        }
                    }
                }
                else if(AuthenticationService.getInstance().getLoginUser()!=null){

                    System.out.println("wellcome " + AuthenticationService.getInstance().getLoginUser().getUsername());

                    int msgCode=0;
                    System.out.println("what do you want?");
                    System.out.println("1.Show My Articles");
                    System.out.println("2.Edit an Article");
                    System.out.println("3.Create new Article");
                    System.out.println("4.Publish an Article");
                    System.out.println("5.Change Password");
                    System.out.println("6.Search for an Article");
                    System.out.println("7.Log Out");
                    Scanner input = new Scanner(System.in);
                    msgCode = input.nextInt();
                    switch (msgCode){
                        case 1:{
                            ShowUserArticlesUseCase showUserArticlesUseCase = new ShowUserArticlesUseCaseImple();
                            List<Article> articles = showUserArticlesUseCase.showArticles();
                            articles.forEach(System.out::println);
                            break;
                        }
                        case 2:{
                            EditArticleByUserUseCase editArticleByUserUseCase = new EditArticleByUserUseCaseImple();
                            editArticleByUserUseCase.Edit();
                            break;
                        }
                        case 3:{



                            CreateNewArticleByUserUseCase createNewArticleByUserUseCase = new CreateNewArticleByUserUseCaseImple();
                            createNewArticleByUserUseCase.Add();
                            break;

                        }
                        case 4:{
                            ShowUserArticlesUseCase showUserArticlesUseCase = new ShowUserArticlesUseCaseImple();
                            List<Article> articles  = showUserArticlesUseCase.showArticles();
                            System.out.println("your articles:");
                            articles.forEach(System.out::println);

                            System.out.println("enter id to publish:");
                            Long x = in.nextLong();
                            PublishAnArticleByUserUseCase publishAnArticleByUserUseCase = new PublishAnArticleByUserUseCaseImple();
                            publishAnArticleByUserUseCase.Publish(x);
                            break;
                        }
                        case 5:{

                            EditPasswordByUserUseCase editPasswordByUserUseCase = new EditPasswordByUserUseCaseImple();
                            editPasswordByUserUseCase.editPassword();

                            break;

                        }
                        case 6:{
                            System.out.println("Enter Author to search by author or Enter title to search by title:");
                            String searchSubject = input.next();
                            if(searchSubject.equals("Author")){
                                System.out.println("Enter Author Name:");
                                String author = in.next();
                                SearchArticleByAuthorUseCase searchArticleByAuthorUseCase = new SearchArticleByAuthorUseCaseImple();
                                List<Article> articles = searchArticleByAuthorUseCase.search(author);
                                articles.forEach(System.out::println);
                            }
                            else if(searchSubject.equals("Title")){
                                System.out.println("Enter title:");
                                String title = in.next();
                                SearchArticleByTitleUseCase searchArticleByTitleUseCase = new SearchArticleByTitleUseCaseImple();
                                Article article = searchArticleByTitleUseCase.search(title);
                                System.out.println(article);
                            }


                            break;

                        }
                        case 7:{
                            AuthenticationService.getInstance().setLoginUser(null);
                            break;
                        }
                    }
                }


        }
    }
}
