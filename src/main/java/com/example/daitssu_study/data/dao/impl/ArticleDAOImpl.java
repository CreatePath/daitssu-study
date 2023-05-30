package com.example.daitssu_study.data.dao.impl;

import com.example.daitssu_study.data.dao.ArticleDAO;
import com.example.daitssu_study.data.entity.Article;
import com.example.daitssu_study.data.entity.User;
import com.example.daitssu_study.data.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ArticleDAOImpl implements ArticleDAO {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleDAOImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article update(Long id, String title, String content, User user) throws Exception {
        Optional<Article> selectedArticle = articleRepository.findById(id);

        Article updatedArticle;
        if (selectedArticle.isPresent()) {
            Article article = selectedArticle.get();

            article.setTitle(title);
            article.setContent(content);
            article.setUpdatedAt(LocalDateTime.now());

            updatedArticle = articleRepository.save(article);
        } else {
            throw new Exception();
        }

        return updatedArticle;

    }

    @Override
    public Article findById(Long id) throws Exception {
        Optional<Article> selectedArticle = articleRepository.findById(id);

        if (selectedArticle.isPresent())
            return selectedArticle.get();
        else
            throw new Exception();
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Article> selectedArticle = articleRepository.findById(id);

        if (selectedArticle.isPresent())
            articleRepository.delete(selectedArticle.get());
        else
            throw new Exception();
    }
}
