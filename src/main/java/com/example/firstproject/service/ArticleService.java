package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service // 서비스 객체 생성
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository; // 게시글 리파지터리 객체 주입

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        // 기존 데이터를 수정하게 하면 안되므로
        // 요청 데이터가 id값을 가지면 null을 반환
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article updated(Long id, ArticleForm dto) {
        // 1. DTO -> 엔티티 변환
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());
        // 2. 타깃 조회
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리
        if (target == null || id != article.getId()) {
            // 400, 잘못된 요청 응답
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return null; // 컨트롤러가 상태 코드 반환해주므로 서비스는 null만 반환
        }
        // 4. 업데이트 및 정상 응답(200)
        target.patch(article); // 기존 데이터에 새 데이터 붙임
        Article updated = articleRepository.save(target); // 수정 내용 db에 최종 저장
        return updated; // 상태코드와 응답은 컨트롤러가 함
    }

    public Article delete(Long id) {
        // 1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리
        if (target == null) {
            return null;
        }
        // 3. 대상 삭제
        articleRepository.delete(target);
        return target;
    }
}
