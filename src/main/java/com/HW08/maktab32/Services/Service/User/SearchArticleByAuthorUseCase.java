package com.HW08.maktab32.Services.Service.User;

import com.HW08.maktab32.entities.Article;

import java.util.List;

public interface SearchArticleByAuthorUseCase {
   List<Article> search(String authorName);
}
