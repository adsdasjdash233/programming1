package hspark.springdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor; // 기본 생성자 추가

import hspark.springdeveloper.dao.Article;

@Getter
@NoArgsConstructor // @RequestBody 매핑을 위해 추가
@AllArgsConstructor
public class ArticleCreationRequest {
    private String title;
    private String content;

    // 반환 타입을 String -> Article로 변경하고 private -> public으로 변경
    public Article toEntity() {
        //return new Article(this.title, this.content);
        return Article.builder().title(this.title).content(this.content).build();
    }
}