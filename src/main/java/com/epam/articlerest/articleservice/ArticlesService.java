package com.epam.articlerest.articleservice;


import com.epam.articlerest.article.Article;
import com.epam.articlerest.article.ArticleList;
import com.epam.articlerest.articlesdao.ArticlesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {
    @Autowired
    private ArticlesDao articlesDao;

    public Article add(Article article) {
        return articlesDao.add(article);
    }

    public Article delete(long id) {
        return articlesDao.delete(id);
    }

    public ArticleList getArticles() {
        return new ArticleList(articlesDao.list());
    }
}
