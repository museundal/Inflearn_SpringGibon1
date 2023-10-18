package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;
// Spring의 자동 주입 옵션에 대해 알아보는 예제, 주입할 빈이 존재하지 않는 경우 어떻게 대응할 것인지

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        //테스트빈을 스프링빈으로 등록하는 과정
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }


    /*
    @Autowired 애노테이션의 required 속성의 기본값은 true입니다. 이는 해당 타입의 빈을 스프링 컨테이너에서 반드시 찾아야 한다는 것을 의미합니다.
    만약 required=true (또는 required 속성을 지정하지 않은 상태)로 설정되어 있고 해당 타입의 빈이 스프링 컨테이너에 존재하지 않는다면, 스프링은 예외를 발생시킵니다.
    이 예외는 컨텍스트의 초기화 단계에서 발생하므로, 이를 잡아내려면 컨테이너 초기화 시점에서 적절한 예외 처리를 해주어야 합니다.
    예를 들어, 위의 코드에서 setNoBean1 메서드의 @Autowired를 required=true로 설정하거나 required를 생략하면, Member 타입의 빈이 컨테이너에 없기 때문에 예외가 발생합니다.
     */

    static class TestBean{
        //@Autowired(required = false)는 스프링이 주입할 대상 빈(Member)을 찾지 못해도 시작에 실패하지 않도록 설정
        //required = false는 해당 빈이 없으면 메서드 자체가 호출되지 않습니다
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired
        // 주입할 빈(Member)이 없으면 null이 주입되도록 합니다.
            public void setNoBean2(@Nullable Member noBean2){
                System.out.println("noBean2 = " + noBean2);
            }
        @Autowired
        // 주입할 빈(Member)이 없을 경우 Optional.empty()가 주입
            public void setNoBean3(Optional<Member> noBean3){
                System.out.println("noBean3 = " + noBean3);
            }

    }
}
