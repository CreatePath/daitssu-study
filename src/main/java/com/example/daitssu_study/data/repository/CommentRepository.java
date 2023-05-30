package com.example.daitssu_study.data.repository;

import com.example.daitssu_study.data.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
