package com.tangjiqunliu.concurrency.example.singleton;

import com.tangjiqunliu.concurrency.annoations.NoThreadSafe;

@NoThreadSafe
public class SingletonExample1 {

    private SingletonExample1(){

    }

    private static SingletonExample1 singletonExample1 = null;

    public static SingletonExample1 gttInstance(){
        if (singletonExample1 == null){
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;
    }
}
