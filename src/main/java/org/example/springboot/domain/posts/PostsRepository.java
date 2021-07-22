package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
                                                    //Entity클래스, PK타입
                                            //JpaRepository를 상속하면 기본적인 CRUD메소드가 자동으로 생성
}
