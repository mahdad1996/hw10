package com.HW08.maktab32;

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
        mySession.beginTransaction();
        boolean condition = true;
        Scanner in= new Scanner(System.in);
        while (condition){
                if(AuthenticationService.getInstance().getLoginUser()==null){
                    int msgCode=0;
                    System.out.println("what do you want? 1.register | 2.login");
                    Scanner input = new Scanner(System.in);
                    msgCode = input.nextInt();
                    switch (msgCode){
                        case 1:{
                            System.out.println("Enter Username:");
                            String username = input.next();
                            System.out.println("Enter National Code:");
                            String nCode = input.next();
                            System.out.println("Enter birthday!");
                            String birth = input.next();
                            DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
                            Date birthday=null;
                            try {
                                birthday =format.parse(birth);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            User user = new User(username,nCode,nCode,birthday);
                            Long id = (Long)  mySession.save(user);
                            mySession.getTransaction().commit();
                            System.out.println("user saved! "+id);

                        }
                        case 2:{
                            System.out.println("enter username:");
                            String username = input.next();
                            System.out.println("enter password:");
                            String password = input.next();

                            Query<User> query = mySession.createQuery("from User where username=:username AND password=:password");
                            query.setParameter("username",username);
                            query.setParameter("password",password);
                            User user;
                            user=query.uniqueResult();

                            mySession.getTransaction().commit();
                            if(user!=null){
                                System.out.println("logged in as "+ user.getUsername());
                                AuthenticationService.getInstance().setLoginUser(user);
                            }

                        }
                    }
                }
                else if(AuthenticationService.getInstance().getLoginUser()!=null){

                    System.out.println("wellcome " + AuthenticationService.getInstance().getLoginUser().getUsername());
                    int msgCode=0;
                    System.out.println("what do you want?");
                    System.out.println("1.show my Articles");
                    System.out.println("2.Edit an Article");
                    System.out.println("3.create new Article");
                    System.out.println("4.change password");
                    System.out.println("5.log out");
                    Scanner input = new Scanner(System.in);
                    msgCode = input.nextInt();
                    switch (msgCode){
                        case 1:{
                            mySession.beginTransaction();
                            Query<Article> query = mySession.createQuery("from Article");
                            List<Article> articles ;
                            articles = query.list();
                            mySession.getTransaction().commit();
                            articles.forEach(System.out::println);
                            break;
                        }
                        case 2:{
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

                            break;
                        }
                        case 3:{
                            System.out.println("avalable categories:");
                            mySession.beginTransaction();
                            Query<Category> query = mySession.createQuery("from Category");
                            List<Category> categories = query.list();
                            mySession.getTransaction().commit();
                            categories.forEach(System.out::println);
                            Long c=-1L;
                            System.out.println("enter id to choose or 0 to add one!");
                            c=in.nextLong();
                            if (c == 0) {
                                System.out.println("enter category title:");
                                String title = in.next();
                                System.out.println("enter category description:");
                                String desc = in.next();
                                Category category = new Category(desc, title);

                                mySession.save(category);
                                mySession.beginTransaction().commit();
                            }
                            mySession.beginTransaction();
                            Category category = mySession.load(Category.class,c);

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


                            User u =AuthenticationService.getInstance().getLoginUser();
                            Article article = new Article(title,brief,content,new Date(),new Date(),publishDate,isp,u,category );
                            mySession.save(article);
                            mySession.getTransaction().commit();

                        }
                    }
                }


        }
    }
}
