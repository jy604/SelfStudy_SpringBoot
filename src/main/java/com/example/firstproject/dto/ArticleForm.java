package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @allargsConstructor 사용하니 기본 생성자 없다고 오류 발생
// @all 지우고 @no 와 @setter 붙이니 오류 풀림
@Setter
@NoArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title; // 제목 필드
    private String content; // 내용 필드

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
