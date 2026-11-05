package hspark.springdeveloper.controller;

import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class Test {

    // 테스트용 내부 DTO 클래스 (실제 프로젝트에서는 dto 패키지의 ArticleResponse 사용)
    public static class ArticleResponse {
        private final Long id;
        private final String title;
        private final String content;

        public ArticleResponse(Long id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }

        @Override
        public String toString() {
            return "ArticleResponse{id=" + id + ", title='" + title + "'}";
        }
    }

    public static void main(String[] args) {
        // 1. 기본 숫자 스트림 연산
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = nums.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .toList();
        System.out.println("짝수 * 2 결과: " + result);

        // 2. 블로그 프로젝트 스타일의 객체 스트림 매핑 (.map(ArticleResponse::new) 형태 응용)
        List<Long> ids = List.of(1L, 2L, 3L);
        List<ArticleResponse> responseList = ids.stream()
                .map(id -> new ArticleResponse(id, "제목 " + id, "내용 " + id))
                .toList();
    }
}