package hspark.springdeveloper.dto;

import hspark.springdeveloper.dao.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {

    private final Long id;       // 게시글 ID 추가
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.id = article.getId(); // ID 매핑
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}