package hspark.springdeveloper.dao;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id; // PK

    @Column(nullable = false)
    private String title; // Not Null

    @Column(nullable = false)
    private String content; // Not Null

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}