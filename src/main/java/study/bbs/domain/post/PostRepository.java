package study.bbs.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select new study.bbs.domain.post.PostResponse(p.id, p.title, p.content, p.createdAt)" +
            "from Post p")
    List<PostResponse> findAllProjectedFields();

    @Query("select new study.bbs.domain.post.PostResponse(p.id, p.title, p.content, p.createdAt)" +
            "from Post p where p.id in:id")
    PostResponse findResponseById(@Param("id") Long id);

    Optional<Post> findByLabel(String label);

}
