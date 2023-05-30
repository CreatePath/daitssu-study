package com.example.daitssu_study.data.dao;

import com.example.daitssu_study.data.entity.Article;
import com.example.daitssu_study.data.entity.User;

public interface ArticleDAO {

    Article create(Article article);

    Article update(Long id, String title, String content, User user) throws Exception;

    Article findById(Long id) throws Exception;

    void delete(Long id) throws Exception;

}
