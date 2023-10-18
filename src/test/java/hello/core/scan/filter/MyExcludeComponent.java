package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent { // 이 인터페이스가 붙으면 컴포넌트에 제외하겠다는 의미~
}
