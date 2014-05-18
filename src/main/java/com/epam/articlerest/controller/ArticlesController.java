package com.epam.articlerest.controller;

import com.epam.articlerest.article.Article;
import com.epam.articlerest.article.ArticleList;
import com.epam.articlerest.articleservice.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArticlesController {
    private static final String TITLE_PARAM = "title";
    private static final String TEXT_PARAM = "text";

    @Autowired
    private ArticlesService articlesService;

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public @ResponseBody Article save(HttpServletRequest req) {
        Article article = new Article();
        article.setTitle(req.getParameter(TITLE_PARAM));
        article.setText(req.getParameter(TEXT_PARAM));
        return articlesService.add(article);
    }

    @RequestMapping(value = {"/articles"}, method = RequestMethod.GET)
    public @ResponseBody ArticleList list() {
        return articlesService.getArticles();
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Article delete(@PathVariable("id") long id) {
        return articlesService.delete(id);
    }
}
