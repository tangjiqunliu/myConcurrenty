package com.tangjiqunliu.concurrency.example.singleton;

import com.tangjiqunliu.concurrency.annoations.NoThreadSafe;
import com.tangjiqunliu.concurrency.annoations.NotReCommend;

@NoThreadSafe
@NotReCommend
public class SingletonExample3 {

    private SingletonExample3(){

    }

    private static SingletonExample3 singletonExample1 = null;

    public static synchronized SingletonExample3 gttInstance(){
        if (singletonExample1 == null){
            singletonExample1 =  new SingletonExample3();
        }
        return singletonExample1;
    }
}
