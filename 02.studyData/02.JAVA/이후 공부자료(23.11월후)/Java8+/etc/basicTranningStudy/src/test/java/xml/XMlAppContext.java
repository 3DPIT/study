package xml;

import com.example.basicTrainning.demo.diJava.member.MemberService;
import com.example.basicTrainning.demo.diJava.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XMlAppContext {

    @Test
    void xmlAppContext(){
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
