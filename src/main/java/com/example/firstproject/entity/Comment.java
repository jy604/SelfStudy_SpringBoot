package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 자동으로 1씩 증가
    private Long id; // 대표키

    @ManyToOne // comment : article 엔티티 다대일 관계로 설정
    @JoinColumn(name="article_id") // 외래키 매핑, article의 기본키인 id와 매핑
    private Article article; // 외래키

    @Column
    private String nickname;

    @Column
    private String body; // 댓글 본문
}
