package com.minwoo.spring_core.singleton;

public class SingletonService {

    // 로드시 jvm에 하나만 올라가는 instance
    private static final SingletonService instance= new SingletonService();

    // static 메소드이기 때문에 SingletonService.getInstance로 바로 호출 가능
    public static SingletonService getInstance(){
        return  instance;
    }
    
    // 외부에서 생성자에 접근하지 못하도록 막음
    private SingletonService() {
    }

    public void logic() {
        System.out.println("singleton Instance");
    }

}
