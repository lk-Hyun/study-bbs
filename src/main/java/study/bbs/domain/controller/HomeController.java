package study.bbs.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.bbs.domain.post.Post;
import study.bbs.domain.post.PostResponse;
import study.bbs.domain.post.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}
