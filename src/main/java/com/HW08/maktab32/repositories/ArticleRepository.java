package com.HW08.maktab32.repositories;

import com.HW08.maktab32.config.hibernate.repositories.CrudRepository;
import com.HW08.maktab32.entities.Article;

public class ArticleRepository extends CrudRepository<Article,Long> {
    private static ArticleRepository articleRepository;

    private ArticleRepository() {

    }

    public static ArticleRepository getInstance() {
        if (articleRepository == null) {
            articleRepository = new ArticleRepository();
        }
        return articleRepository;
    }
    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }


}
