package com.example.daitssu_study.data.dto.response;

import com.example.daitssu_study.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {

    private Long id;

    private String title;

    private String content;

    private User user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
