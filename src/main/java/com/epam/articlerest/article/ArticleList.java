package com.epam.articlerest.article;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "articles")
public class ArticleList {
    @XmlElement
    @JsonProperty("articles")
    private List<Article> articles;

    public ArticleList(List<Article> articles) {
        this.articles = articles;
    }

    public ArticleList() {}
}
