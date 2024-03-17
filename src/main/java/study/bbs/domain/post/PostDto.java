package study.bbs.domain.post;

public record PostDto(
        Long id,
        String password,
        String title,
        String content
) {
}
