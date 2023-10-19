package hello.core.beanfine;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("빈 이름 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
       // System.out.println("memberService = " + memberService);
        //System.out.println("memberService = " + memberService.getClass());

        //멤버 서비스가 멤버서비스Impl의 인스턴스면 성공!
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }
    @Test
    @DisplayName("빈 이름으로 조회가 X ")
    void findBeanByNameX(){
        //ac.getBean("zz", MemberService.class);  멤버 서비스(?) 에 없다.
//        MemberService xxx =  ac.getBean("zz", MemberService.class);
//        assertThrows(NoSuchBeanDefinitionException.class,
//                ()->ac.getBean("zz", MemberService.class));

        //화살표 오른쪽에 있는 코드가 실행이 되면 왼쪽에 있는 예외가 터져야 한다는 뜻

        assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("zz",MemberService.class));

    }
}
