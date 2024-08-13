package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title; // 제목 필드
    private String content; // 내용 필드

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
