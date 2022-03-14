package com.minwoo.spring_core.singleton;

public class StatefulService {

    // private int price; 전역변수는 싱글톤에서 위험할 수 있으므로 지양

    // 가급적 지역변수를 사용하여야 공유되지 않음음
    public int order(String name, int price) {
        System.out.println(name + price);
        return price;
    }

}
