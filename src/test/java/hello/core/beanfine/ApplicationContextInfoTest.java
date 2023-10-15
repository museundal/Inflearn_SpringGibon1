package hello.core.beanfine;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDenfinitionNames = ac.getBeanDefinitionNames();
        for (String beanDenfinitionName : beanDenfinitionNames) {
            //타입이 정해져 있지 않기 때문에 객체가 꺼내진다.
            Object bean = ac.getBean(beanDenfinitionName);
            //soutm 메서드 명을 찍어준다
            //System.out.println("ApplicationContextInfoTest.findAllBean");
            //soutv 변수명을 찍어준다
            //System.out.println("bean = " + bean);

            //키와 값
            System.out.println("name =  " +beanDenfinitionName+" object = " + bean );
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDenfinitionNames = ac.getBeanDefinitionNames();
        for (String beanDenfinitionName : beanDenfinitionNames) {
            // bean  하나하나에 대한 정보
           BeanDefinition beanDefinition = ac.getBeanDefinition(beanDenfinitionName);

            //ROLE_APPLICATION : 직접 등록한 어플리케이션 빈
            // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
           if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
               Object bean = ac.getBean(beanDenfinitionName);
               System.out.println("name =  " +beanDenfinitionName+" object = " + bean );
           }
        }
    }
}
