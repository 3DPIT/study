package kr.co.black.mockito.controllerTestMain.repository;

import kr.co.black.mockito.controllerTestMain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
