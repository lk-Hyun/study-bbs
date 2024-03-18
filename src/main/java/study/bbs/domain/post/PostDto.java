package study.bbs.domain.post;

public record PostDto(
        Long memberId,
        Long id,
        String label,
        String password,
        String title,
        String content
) {

    public Post toEntity() {
        return Post.builder().label(label).title(title).content(content).password(password).build();
    }
}
