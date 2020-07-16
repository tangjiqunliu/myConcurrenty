package com.tangjiqunliu.concurrency.example.singleton;

import com.tangjiqunliu.concurrency.annoations.ReCommend;
import com.tangjiqunliu.concurrency.annoations.ThreadSafe;

@ThreadSafe
@ReCommend
public class SingletonExample6 {

    private SingletonExample6(){

    }

    private enum Singleton{
        instance;
        private SingletonExample6 singletonExample6;

        Singleton(){
            singletonExample6 = new SingletonExample6();
        }
        public SingletonExample6 getInstance(){
            return singletonExample6;
        }
    }


    public static SingletonExample6 getInstance(){
        return Singleton.instance.getInstance();
    }
}
