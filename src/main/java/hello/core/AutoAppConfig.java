package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan ( // 자동으로 스프링빈을 끌어 올려야한다.
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
        //Configuration이 붙은것도 스프링빈으로 되어 있어서 , 빈설정을 도와주는 클래스임으로 필터링 해야함 (컴포넌트 스캔 안되도록)
)
public class AutoAppConfig {


}
