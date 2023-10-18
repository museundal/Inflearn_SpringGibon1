package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 타입이라고 하면 클래스 레벨에 붙는 것.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent { // 이 인터페이스가 붙으면 컴포넌트에 추가하겠다는 의미~
}
