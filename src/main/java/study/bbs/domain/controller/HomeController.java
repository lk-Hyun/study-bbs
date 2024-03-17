package study.bbs.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.bbs.domain.post.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final PostService postService;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/board")
    public ResponseEntity<List<Object[]>> members() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }
}
