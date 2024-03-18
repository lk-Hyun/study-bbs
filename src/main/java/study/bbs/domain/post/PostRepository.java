package study.bbs.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p.id, p.password, p.title, p.content FROM Post p")
    List<Object[]> findAllProjectedFields();

    Optional<Post> findByLabel(String label);

}
