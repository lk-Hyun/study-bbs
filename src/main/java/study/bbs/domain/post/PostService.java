package study.bbs.domain.post;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.bbs.domain.member.MemberRepository;

import java.util.List;

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
    private final MemberRepository memberRepository;

    /**
     *  게시글은 최소 제약 조건만 넘기면 생성가능
     *  test 를 위해 Long 반환
     */
    public Long posting(PostRequest dto) throws Exception {
        Post post = dto.toEntity();
        // member 가 존재한다면 member_id 할당
        if (dto.memberId() != null) {
            memberRepository.findById(dto.memberId()).ifPresent(post::setMember);
        }

        return postRepository.save(post).getId();
    }

    /* password 일치 시 수정 */
    public void update(PostRequest dto) throws Exception {
        Post post = postRepository.findById(dto.id()).orElseThrow(
                () -> new Exception("잘못된 정보입니다.")
        );

        if (!post.getPassword().equals(dto.password())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

        post.updateContent(dto.content());
    }

    /* password 일치 시 삭제 */
    public void delete(PostRequest dto) throws Exception {
        Post post = postRepository.findById(dto.id()).orElseThrow(
                () -> new Exception("잘못된 정보입니다.")
        );

        if (post.getPassword().equals(dto.password())) {
            postRepository.deleteById(post.getId());
        }
    }

    /* for test */
    public List<Object[]> getAllPosts() {
        return  postRepository.findAllProjectedFields();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).get();
    }
}
