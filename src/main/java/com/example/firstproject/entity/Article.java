package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor // 매개변수 없는 기본생성자 추가
@ToString
@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 대표값 자동 생성
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    // 데이터 일부 수정할 경우 동작
    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }

    // lombok 사용 안할 시
//    public Long getId() {
//        return id;
//    }
}
