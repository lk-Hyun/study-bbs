package study.bbs.domain.post;

import jakarta.persistence.*;
import lombok.*;
import study.bbs.domain.BaseTimeEntity;
import study.bbs.domain.member.Member;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private String label;

    /* 익명 게시글 생성 비밀번호, 게시글 삭제 시 참조 */
    private String password;

    private String title;
    private String content;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void updateContent(String content) {
        this.content = content;
    }

}
