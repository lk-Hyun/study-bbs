package study.bbs.domain.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired PostService postService;

//    @BeforeEach
//    void before() {
//        PostDto dto = new PostDto("test-label", null, "1234", "test-title", "hello world");
//    }

    @Test
    void posting_success() throws Exception {
        PostDto dto = new PostDto(null, 6L, "g-label", "1234", "test-title", "hello world");

        //when
        Long posting = postService.posting(dto);
        //then

        Post post = postService.getPost(posting);
        assertEquals(post.getId(), posting);
    }

    @Test
    void posting_fail() throws Exception {
        //invalidate condition
    }

    @Test
    void update_success() throws Exception {
        PostDto dto = new PostDto(null, 1L, "new-label", "1234", "new-title!", "new-content!");

        //when
        Post post = postService.getPost(1L);
        postService.update(dto);

        //then
        assertEquals(dto.content(), postService.getPost(1L).getContent());
    }

    @Test
    void update_not_eq_label() throws Exception {
        //given
        Post post = postService.getPost(6L);

        //when


        //then
    }
}