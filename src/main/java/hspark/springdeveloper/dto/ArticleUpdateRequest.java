package hspark.springdeveloper.dto;

import hspark.springdeveloper.dao.Article;
import lombok.AllArgsConstructor;
import lombok.Getter; // 1. 겟터 어노테이션 임포트

@Getter // 2. 클래스 위에 @Getter 추가
@AllArgsConstructor
public class ArticleUpdateRequest {
    private String title;
    private String content;

    //@AllArgsConstructor에 아래가 포함
//    public ArticleUpdateRequest(String title, String content) {
//        this.title = title;
//       this.content = content;
//    } // 괄호 닫는 것도 살짝 정리해주시면 좋습니다.
}