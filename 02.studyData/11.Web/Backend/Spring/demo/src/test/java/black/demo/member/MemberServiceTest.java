package black.demo.member;

import black.demo.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        //AppConfig appConfig = new AppConfig();
        //memberService = appConfig.memberService();
        ApplicationContext ac =  new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = ac.getBean("memberService",MemberService.class);
    }

    @Test
    void Join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }
}
