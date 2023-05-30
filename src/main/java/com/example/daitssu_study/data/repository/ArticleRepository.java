package com.example.daitssu_study.data.repository;

import com.example.daitssu_study.data.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
