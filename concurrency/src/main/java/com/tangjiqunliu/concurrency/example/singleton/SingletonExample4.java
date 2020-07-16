package com.tangjiqunliu.concurrency.example.singleton;

import com.tangjiqunliu.concurrency.annoations.NoThreadSafe;
import com.tangjiqunliu.concurrency.annoations.NotReCommend;

@NoThreadSafe
@NotReCommend
public class SingletonExample4 {

    private SingletonExample4(){

    }

    private static SingletonExample4 singletonExample1 = null;

    public static  SingletonExample4 gttInstance(){
        if (singletonExample1 == null){
            synchronized (SingletonExample4.class){
                if (singletonExample1 == null){
                    singletonExample1 =  new SingletonExample4();
                }
            }
        }
        return singletonExample1;
    }
}
