package hspark.springdeveloper.repository;

import hspark.springdeveloper.dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
    // fingBy(), findAll(), save() , saveAll(), deleteById(), deleteAll()
}
