package week1.test;

import java.util.List;

class Bird {
    public void fly() {
        System.out.println("새가 날아다닙니다.");
    }
}

class Hawk extends Bird {
    @Override
    public void fly(){
        System.out.println("독수리가 날아다닙니다.");
    }

    public void hunting(){
        System.out.println("독수리가 사냥합니다.");
    }
}

public class Test {
    public static void main(String[] args) {
        Hawk hawk = new Hawk();
        // 구현된 클래스를 활용해 업 캐스팅을 이어서 구현하시오.
        //자동 업캐스팅이 이루어진다.
        Bird bird_up = hawk;

        // 해당 메소드를 호출하면 어떠한 결과가 나오는지 작성하시오.
        // 업캐스팅한 변수.fly();
        // 업캐스팅한 변수.hunting();
        bird_up.fly();
        /*
        bird.hunting(); 은 안됨.
        참조하는 인스턴스 종류에 관계없이, 참조변수의 형에 해당하는 클래스와 그 클래스가 상속하는 상위 클래스에 정의된 메소드만 사용 가능합니다.
         */

        // 구현된 클래스를 활요해 다운 캐스팅을 이어서 구현하시오
        Hawk bird_down = (Hawk) bird_up;

        // 해당 메소드를 호출하면 어떠한 결과가 나오는지 작성하시오.
        // 다운캐스팅한 변수.fly();
        // 다운캐스팅한 변수.hunting();

        bird_down.fly();
        bird_down.hunting();
        /*
        독수리가 날아다닙니다.
        독수리가 사냥합니다.
        오버라이딩된 메소드가 상속받은 클래스의 상황 및 맥락에 맞게 재정의되어 Bird 클래스의 fly() 메소드가 아닌 Hawk 클래스의 fly() 메소드가 실행됩니다.

         */

        // 리스트의 자료형을 Bird로 구현하여 bird_up과 bird_down 을 리스트에 구현하시오.
        List<Bird> birdList = List.of(bird_down, bird_up);

        // 리스트를 반복문을 통해 fly문을 호출하시오.
        birdList.forEach(Bird::fly);

        // 예외 문제 1) 발생하는 예외를 기재하시오.
        // Integer.parseInt("d1234");
        /*
        d를 int 타입으로 형변환 도중 런타임 에러로 NumberFormatException 이 발생합니다.
         */

        // 예외 문제 2) 해당 코드의 오류가 있다면, 오류를 수정하고 수정한 이유를 적으시오.
        /* int[] arr = new int[3];
         *  for(int i = 0; i < 4; i++) {
         *      arr[i] = i;
         *  }
         */

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = i;
        }
    }
}
