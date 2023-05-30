package com.example.daitssu_study.data.dao;

import com.example.daitssu_study.data.entity.Article;
import com.example.daitssu_study.data.entity.Comment;
import com.example.daitssu_study.data.entity.User;

public interface CommentDAO {

    Comment create(String content, Article article, User user);

    Comment update(Long id, String content);

    Comment findByArticle(Article article);

    void delete(Long id);
}
