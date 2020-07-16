package com.tangjiqunliu.concurrency.example.singleton;

import com.tangjiqunliu.concurrency.annoations.ThreadSafe;

@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2(){

    }

    private static SingletonExample2 singletonExample1 = new SingletonExample2();

    public static SingletonExample2 gttInstance(){
        return singletonExample1;
    }
}
