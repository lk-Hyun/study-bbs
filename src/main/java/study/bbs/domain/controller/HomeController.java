package study.bbs.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.bbs.domain.member.Member;
import study.bbs.domain.post.Post;
import study.bbs.domain.post.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/members")
    public List<Object[]> members() {
        return postService.getAllPosts();
    }
}
