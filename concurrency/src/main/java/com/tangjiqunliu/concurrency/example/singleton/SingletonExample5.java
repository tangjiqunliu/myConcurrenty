package com.tangjiqunliu.concurrency.example.singleton;

import com.tangjiqunliu.concurrency.annoations.ThreadSafe;

@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5(){

    }

    private static volatile SingletonExample5 singletonExample1 = null;

    public static SingletonExample5 gttInstance(){
        if (singletonExample1 == null){
            synchronized (SingletonExample5.class){
                if (singletonExample1 == null){
                    singletonExample1 =  new SingletonExample5();
                }
            }
        }
        return singletonExample1;
    }
}
