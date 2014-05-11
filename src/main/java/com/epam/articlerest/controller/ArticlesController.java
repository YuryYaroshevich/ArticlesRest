package com.epam.articlerest.controller;

import com.epam.articlerest.article.Article;
import com.epam.articlerest.article.ArticleList;
import com.epam.articlerest.articleservice.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ArticlesController {
    private static final String TITLE_PARAM = "title";
    private static final String TEXT_PARAM = "text";

    @Autowired
    private ArticlesService articlesService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Article save(HttpServletRequest req) {
        Article article = new Article();
        article.setTitle(req.getParameter(TITLE_PARAM));
        article.setText(req.getParameter(TEXT_PARAM));
        return articlesService.add(article);
    }

    @RequestMapping(value = {"/list" , "/"}, method = RequestMethod.GET)
    public @ResponseBody ArticleList list() {
        return articlesService.getArticles();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public @ResponseBody Article delete(@PathVariable("id") long id) {
        return articlesService.delete(id);
    }
}
