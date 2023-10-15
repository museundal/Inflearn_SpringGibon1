package hello.core.singleton;

public class StatefulService {

    //private int price; // 상태를 유지하는 필드 , 근데 변경될 가능성이 있어버림 무상태성이 되도록 해야한다.


    public int order(String name, int price){
        System.out.println("name = " +name+" price = "+ price);
        //this.price = price; //여기가 문제 !, 무상태성으로 바꾸면서 그냥 리턴해버리자
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
