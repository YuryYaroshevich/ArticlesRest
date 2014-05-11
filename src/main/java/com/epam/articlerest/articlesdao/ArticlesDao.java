package com.epam.articlerest.articlesdao;

import com.epam.articlerest.article.Article;

import java.util.List;


public interface ArticlesDao {
    Article add(Article article);

    Article delete(long id);

    List<Article> list();
}
