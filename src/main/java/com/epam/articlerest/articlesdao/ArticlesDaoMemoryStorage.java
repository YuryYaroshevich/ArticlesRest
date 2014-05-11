package com.epam.articlerest.articlesdao;


import com.epam.articlerest.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class ArticlesDaoMemoryStorage implements ArticlesDao {
    private List<Article> articles;

    @Autowired
    private IdGenerator idGenerator;

    ArticlesDaoMemoryStorage() {
        this.articles = new ArrayList<Article>();
    }

    @Override
    public Article add(Article article) {
        article.setId(idGenerator.generate());
        articles.add(article);
        return article;
    }

    @Override
    public Article delete(long id) {
        Iterator<Article> iter = articles.iterator();
        while (iter.hasNext()) {
            Article article = iter.next();
            if (article.getId() == id) {
                iter.remove();
                return article;
            }
        }
        return null;
    }

    @Override
    public List<Article> list() {
        return articles;
    }
}
