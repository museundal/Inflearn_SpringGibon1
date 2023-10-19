package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //1.어디선가 AppConfig를 통해서 멤버서비스를 불러다 쓸텐데 서비스Impl 구현체가 생성이 되면서 메모리 멤버 리포지토리도 들어간다.
    //2.그러면 멤버 서비스impl에  메모리멤버 리포지토리 코드는 없지만 자동 주입된다.
    @Bean
    public MemberService memberService(){ //역할이 눈에 보임
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){ // 역할
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){ // 역할
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy() );
        //return null;
    }@Bean
    public DiscountPolicy discountPolicy(){//역할
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
