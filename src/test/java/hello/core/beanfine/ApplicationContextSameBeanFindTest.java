package hello.core.beanfine;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    //이걸 사용하면 AppConfig 손봐야 하니까 , 여기서만 사용할 class static으로 선언하기
   // AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    //스프링 컨테이너 역할을 하는 컨테스트
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상있으면 , 중복오류가 발생한다")
    void findBeanByTypeDuplicate(){
       // MemberRepository bean = ac.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상있으면,빈 이름을 지정하면 된다")
    void findBeanByName(){
        //빈 이름을 지정하여 조회, 지정된 이름을 사용하여 repository를 가져오면서 이 빈이 클래스의 인스턴스인지 확인
        MemberRepository repository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(repository).isInstanceOf(MemberRepository.class);

    }

    @Test
    @DisplayName("특정타입을 모두 조회하기")
    void findAllBeansByType() {

        Map<String,MemberRepository> beansOfType =ac.getBeansOfType(MemberRepository.class);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration // Java 구성 클래스를 선언할 때 사용
    static class SameBeanConfig { //클래스 안에서 클래스를 썼다는 것은 여기 안에서만 scope을 사용하겠단 뜻입니다.

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }

    }
}
