package study.bbs.domain.post;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PostService {

    /**
     * 게시글 생성
     * 게시글 수정
     * 게시글 삭제
     */

    private final PostRepository postRepository;

    /**
     *  게시글은 최소 제약 조건만 넘기면 생성가능
     *  test 를 위해 Long 반환
     */
    public Long posting(Post post) throws Exception {
        return postRepository.save(post).getId();
    }

    public void update(PostDto dto) throws Exception {
        Post post = postRepository.findById(dto.id()).orElseThrow(
                () -> new Exception("잘못된 정보입니다.")
        );

        if (!post.getPassword().equals(dto.password())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

        post.updateContent(dto.content());
    }

    public void delete(PostDto dto) throws Exception {
        Post post = postRepository.findById(dto.id()).orElseThrow(
                () -> new Exception("잘못된 정보입니다.")
        );

        if (post.getPassword().equals(dto.password())) {
            postRepository.deleteById(post.getId());
        }
    }
}
