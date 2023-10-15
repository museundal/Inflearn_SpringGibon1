package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
   void statefulServiceSingleton(){
        //아래의 스프링컨테이너는 그냥 statefulService를 생성해서 쓰는 역할
        ApplicationContext ac= new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자가 10000원을 주문
        int userA_price = statefulService1.order("userA",10000);
        //ThreadB : B사용자가 20000원을 주문
        int userB_price = statefulService2.order("userB",20000);

        //ThreadA : A사용자 주문금액조회
//        int priceA= statefulService1.getPrice();
//        System.out.println(priceA);
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);

        System.out.println("userA price = " + userA_price);
        System.out.println("userB price = " + userB_price);
        assertThat(userA_price).isEqualTo(10000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}