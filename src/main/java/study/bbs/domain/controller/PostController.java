package study.bbs.domain.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.bbs.domain.post.Post;
import study.bbs.domain.post.PostRequest;
import study.bbs.domain.post.PostResponse;
import study.bbs.domain.post.PostService;

import java.util.List;

@Tag(name = "Posts", description = "게시판 API")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/board")
    public List<Object[]> posts() {
        return postService.getAllPosts();
    }

    @Parameter(name = "id", in = ParameterIn.PATH)
    @GetMapping("/board/{id}")
    public PostResponse getPost(@PathVariable(name = "id") Long id) {
        log.info("param id = {}", id);
        Post post = postService.getPost(id);

        return new PostResponse(id, post.getTitle(), post.getContent(), post.getCreatedAt());
    }

    @PostMapping("/board")
    public ResponseEntity posting(@RequestBody PostRequest dto) {
        try {
            postService.posting(dto);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * post_id, label, password, raw_content
     */
    @PutMapping("/board")
    public ResponseEntity updatePost(@RequestBody PostRequest dto) {
        try {
            postService.update(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
