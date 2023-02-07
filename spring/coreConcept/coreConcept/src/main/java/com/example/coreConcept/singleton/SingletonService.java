package com.example.coreConcept.singleton;

public class SingletonService {
    private static final SingletonService instance=new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //★★★★생성자를 public->private로 바꿔서 외부에서 new로 새로 생성하는것을 방지한다.
    private SingletonService() {}
}
