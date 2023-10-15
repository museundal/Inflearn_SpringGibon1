package hello.core.singleton;

public class SingletonService {
    // 자기 자신을 내부에 하나 가지고 있는데 static으로 가지고 있다.
    //JVM 자바가 딱 뜰 때 , 자기 자신 객체를 생성해서 instance에 넣고
    private static final SingletonService instance = new SingletonService();

    private SingletonService() {
    }

    //조회할 때
     public static SingletonService getInstance() {
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직을 호출했다.");
    }

}
