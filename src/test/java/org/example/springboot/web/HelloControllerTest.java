package org.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    //테스트를 진행할때 SpringRunner라는 스프링 실행자를 사용, 스프링부트 테스트와 JUnit사이의 연결자
@WebMvcTest(controllers = HelloController.class)    //Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired  //스프링이 관리하는 Bean을 주입받음
    private MockMvc mvc;    //웹 API를 테스트할때 사용

    @Test
    public void hello() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))  //MocMvc를 통해 /hello주소로 get요청
                .andExpect(status().isOk())   //HTTP Header의 Status가 200인지 검증
                .andExpect(content().string(hello));    //mvc.perform의 결과를 검증증
   }

   @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

       mvc.perform(
               get("/hello/dto")
                       .param("name", name)     //API 테스트할때 사용될 요청 파라미터 설정, String만 허용
                       .param("amount", String.valueOf(amount)))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name", is(name)))     //json응답값을 필드별로 검증할 수 있는 메소드
               .andExpect(jsonPath("$.amount", is(amount)));    //$를 기준으로 필드명을 명시
   }
}
