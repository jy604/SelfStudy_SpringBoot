package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue // 대표값 자동 생성
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    // lombok 사용 안할 시
//    public Long getId() {
//        return id;
//    }
}
