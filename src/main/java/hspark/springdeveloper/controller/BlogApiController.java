package hspark.springdeveloper.controller;

import hspark.springdeveloper.dao.Article;
import hspark.springdeveloper.dto.ArticleCreationRequest;
import hspark.springdeveloper.dto.ArticleResponse;
import hspark.springdeveloper.dto.ArticleUpdateRequest;
import hspark.springdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleCreationRequest articleCreationRequest) {
        // 서비스에게 블로그 글 등록을 의뢰.
        Article savedArticle = blogService.save(articleCreationRequest);
        // 성공했다면 ResponseEntity 객체를 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {
        /*
        public ResponseEntity<List<ArticleResponse>> getAllArticles() {
            List<Article> articleList = blogService.findAll();
            List<ArticleResponse> articleResponseList = new ArrayList<>();
            for (Article article : articleList) {
                articleResponseList.add(new ArticleResponse(article));
            }
        */
        List<ArticleResponse> articleResponseList = blogService.findAll().stream().map(ArticleResponse::new).toList();
        return ResponseEntity.ok().body(articleResponseList);
    }
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);
        return ResponseEntity.ok()
                .build();
    }
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable long id, @RequestBody ArticleUpdateRequest request) {
        Article article = blogService.updateArticle(id, request);
        ArticleResponse ArticleResponse = new ArticleResponse(article);
        return ResponseEntity.ok().body(ArticleResponse);
    }



}