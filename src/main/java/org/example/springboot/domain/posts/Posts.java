package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter     //클래스 내 모든 필드의 Getter 메소드 생성
@NoArgsConstructor  //기본 생성자 자동 추가 public Posts(){}
@Entity     //실제 DB테이블과 매칭될 클래스
            //디비의 언더스코어 네이밍을 클래스의 카멜로 매칭 (sales_manager -> SalesManager)
public class Posts {

    @Id     //테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //PK의 생성규칙, GenerationType.IDENTITY옵션은 AI
    private Long id;    //PK는 long타입의 Auto_increment 추천

    @Column(length = 500, nullable = false)     //테이블의 칼럼, 기본값 외에 추가로 변경이 있으면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    //생성자에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
