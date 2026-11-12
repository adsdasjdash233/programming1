package hspark.springdeveloper.service;

import hspark.springdeveloper.dao.Article;
import hspark.springdeveloper.dto.ArticleCreationRequest;
import hspark.springdeveloper.dto.ArticleUpdateRequest;
import hspark.springdeveloper.repository.BlogRepository;
import jakarta.transaction.Transactional;
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

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    public void update(Article article) {
        blogRepository.save(article);
    }

    // 컨트롤러에서 호출하는 updateArticle 메서드 추가
    @Transactional
    public Article updateArticle(long id, ArticleUpdateRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}


