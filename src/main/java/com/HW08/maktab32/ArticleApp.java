package com.HW08.maktab32;

import com.HW08.maktab32.Services.Service.Admin.*;
import com.HW08.maktab32.Services.Service.User.*;
import com.HW08.maktab32.Services.ServiceImpl.Admin.*;
import com.HW08.maktab32.Services.ServiceImpl.User.*;
import com.HW08.maktab32.config.hibernate.HibernateUtil;
import com.HW08.maktab32.entities.Article;
import com.HW08.maktab32.entities.Role;
import com.HW08.maktab32.entities.Tag;
import com.HW08.maktab32.shared.AuthenticationService;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();

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
                            break;

                        }
                        case 2:{
                            LoginUserUseCase loginUserUseCase = new LoginUserUseCaseImple();
                            loginUserUseCase.login();
                            break;

                        }
                        case 3:{
                            ShowAllArticlesUseCase showAllArticlesUseCase = new ShowAllArticlesUseCaseImple();
                            List<Article> articles = new ArrayList<>();
                            articles=showAllArticlesUseCase.showAll();
                            articles.forEach(System.out::println);
                            break;
                        }
                    }
                }
                else if(AuthenticationService.getInstance().getLoginUser()!=null && AuthenticationService.getInstance().getLoginUser().getRoles().stream().anyMatch(r -> r.getId()==2)) {
                    System.out.println("wellcome " + AuthenticationService.getInstance().getLoginUser().getUsername());

                    int msgCode = 0;
                    System.out.println("what do you want?");
                    System.out.println("1.Show My Articles");
                    System.out.println("2.Edit an Article");
                    System.out.println("3.Create new Article");
                    System.out.println("4.Change Password");
                    System.out.println("5.Search for an Article");
                    System.out.println("6.Log Out");
                    Scanner input = new Scanner(System.in);
                    msgCode = input.nextInt();
                    switch (msgCode) {
                        case 1: {
                            ShowUserArticlesUseCase showUserArticlesUseCase = new ShowUserArticlesUseCaseImple();
                            List<Article> articles = showUserArticlesUseCase.showArticles();
                            articles.forEach(System.out::println);
                            break;
                        }
                        case 2: {
                            EditArticleByUserUseCase editArticleByUserUseCase = new EditArticleByUserUseCaseImple();
                            editArticleByUserUseCase.Edit();
                            break;
                        }
                        case 3: {


                            CreateNewArticleByUserUseCase createNewArticleByUserUseCase = new CreateNewArticleByUserUseCaseImple();
                            createNewArticleByUserUseCase.Add();
                            break;

                        }
                        case 4: {
                            EditPasswordByUserUseCase editPasswordByUserUseCase = new EditPasswordByUserUseCaseImple();
                            editPasswordByUserUseCase.editPassword();
                            break;
                        }
                        case 5: {

                            System.out.println("Enter Author to search by author or Enter title to search by title:");
                            String searchSubject = input.next();
                            if (searchSubject.equals("Author")) {
                                System.out.println("Enter Author Name:");
                                String author = in.next();
                                SearchArticleByAuthorUseCase searchArticleByAuthorUseCase = new SearchArticleByAuthorUseCaseImple();
                                List<Article> articles = searchArticleByAuthorUseCase.search(author);
                                articles.forEach(System.out::println);
                            } else if (searchSubject.equals("Title")) {
                                System.out.println("Enter title:");
                                String title = in.next();
                                SearchArticleByTitleUseCase searchArticleByTitleUseCase = new SearchArticleByTitleUseCaseImple();
                                Article article = searchArticleByTitleUseCase.search(title);
                                System.out.println(article);
                            }


                            break;

                        }
                        case 6: {
                            AuthenticationService.getInstance().setLoginUser(null);
                            break;

                        }
                    }
                }
                  else if (AuthenticationService.getInstance().getLoginUser()!=null && AuthenticationService.getInstance().getLoginUser().getRoles().stream().anyMatch(role -> role.getId()==1)){
                        System.out.println("wellcome " + AuthenticationService.getInstance().getLoginUser().getUsername());

                        int msgCode = 0;
                        System.out.println("what do you want?");
                        System.out.println("1.Publish Article");
                        System.out.println("2.Unpublish Article");
                        System.out.println("3.Delete Article");
                        System.out.println("4.Create new Category");
                        System.out.println("5.Create new Tag");
                        System.out.println("6.Edit Users Role");
                        System.out.println("7.Create new Article");
                        System.out.println("8.Edit Article");
                        System.out.println("9.Show All Articles");
                        System.out.println("10.Add new Role");
                        System.out.println("11.Log Out");
                    Scanner input = new Scanner(System.in);
                    msgCode = input.nextInt();
                    switch (msgCode){
                        case 1:{
                            ShowAllArticlesToAdminUseCase showAllArticlesToAdminUseCase = new ShowAllArticlesToAdminUseCaseImpl();
                            showAllArticlesToAdminUseCase.showAllArticles();
                            System.out.println("enter Id to publish");
                            Long articleId = in.nextLong();
                            PublishArticleByAdminUseCase publishArticleByAdminUseCase = new PublishArticleByAdminUseCaseImpl();
                            publishArticleByAdminUseCase.publish(articleId);
                            break;
                        }
                        case 2:{

                            ShowAllArticlesToAdminUseCase showAllArticlesToAdminUseCase = new ShowAllArticlesToAdminUseCaseImpl();
                            showAllArticlesToAdminUseCase.showAllArticles();
                            System.out.println("enter Id to Unpublish");
                            Long articleId = in.nextLong();
                            UnpublishArticleByAdminUseCase unpublishArticleByAdminUseCase = new UnpublishArticleByAdminUseCaseImpl();
                            unpublishArticleByAdminUseCase.unpublish(articleId);
                            break;

                        }
                        case 3:{
                            ShowAllArticlesToAdminUseCase showAllArticlesToAdminUseCase = new ShowAllArticlesToAdminUseCaseImpl();
                            showAllArticlesToAdminUseCase.showAllArticles();
                            System.out.println("enter Id to Delete");
                            Long articleId = in.nextLong();
                            DeleteArticleByAdminUseCase deleteArticleByAdminUseCase = new DeleteArticleByAdminUseCaseImpl();
                            deleteArticleByAdminUseCase.Delete(articleId);
                            break;
                        }
                        case 4:{
                            AddCategoryByAdminUseCase addCategoryByAdminUseCase = new AddCategoryByAdminUseCaseImpl();
                            addCategoryByAdminUseCase.Add();
                            break;
                        }
                        case 5:{
                            Tag tag = new Tag();
                            System.out.println("enter Title for tag:");
                            String title = in.next();
                            tag.setTitle(title);
                            AddNewTagByAdminUseCase addNewTagByAdminUseCase = new AddNewTagByAdminUseCaseImpl();
                            addNewTagByAdminUseCase.Add(tag);
                            break;
                        }
                        case 6:{
                            ShowAllWritersByAdminUseCase showAllWritersByAdminUseCase = new ShowAllWritersByAdminUseCaseImpl();
                            showAllWritersByAdminUseCase.ShowWriters();
                            System.out.println("Enter user id:");
                            Long userId = in.nextLong();

                            ShowAllRolesByAdminUseCase showAllRolesByAdminUseCase = new ShowAllRolesByAdminUseCaseImple();
                            showAllRolesByAdminUseCase.ShowRoles();

                            System.out.println("Enter Role Id");
                            Long roleId = in.nextLong();

                            EditUsersRoleByAdminUseCase editUsersRoleByAdminUseCase = new EditUsersRoleByAdminUseCaseImple();
                            editUsersRoleByAdminUseCase.Edit(userId,roleId);
                            break;
                        }
                        case 7:{
                            CreateArticleByAdminUseCase createArticleByAdminUseCase = new CreateArticleByAdminUseCaseImpl();
                            createArticleByAdminUseCase.Create();
                            break;
                        }
                        case 8:{
                            EditArticleByAdminUseCase editArticleByAdminUseCase = new EditArticleByAdminUseCaseImpl();
                            editArticleByAdminUseCase.Edit();
                            break;
                        }
                        case 9:{
                            ShowAllArticlesToAdminUseCase showAllArticlesToAdminUseCase = new ShowAllArticlesToAdminUseCaseImpl();
                            showAllArticlesToAdminUseCase.showAllArticles();
                            break;
                        }
                        case 10:{
                            System.out.println("Enter Role Title:");
                            String roleTitle = in.next();
                            Role role = new Role();
                            role.setTitle(roleTitle);
                            AddNewRoleByAdminUseCase addNewRoleByAdminUseCase = new AddNewRoleByAdminUseCaseImpl();
                            addNewRoleByAdminUseCase.Add(role);
                            System.out.println("Role Added Succesfuly!");
                            break;
                        }
                        case 11:{
                            AuthenticationService.getInstance().setLoginUser(null);
                            break;
                        }
                    }
                    }



        }
    }
}
