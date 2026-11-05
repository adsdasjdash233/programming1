package hspark.springdeveloper.service;

import hspark.springdeveloper.dao.Article;
import hspark.springdeveloper.dto.ArticleCreationRequest;
import hspark.springdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(ArticleCreationRequest articleCreationRequest) {
        // DTO를 엔티티(DAO)로 변환하여 JpaRepository의 save() 메서드로 저장
        return blogRepository.save(articleCreationRequest.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }
}