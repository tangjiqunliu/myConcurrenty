package com.tangjiqunliu.concurrency.example.atomic;

import com.tangjiqunliu.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicExample6 {
    private static AtomicBoolean isHappend = new AtomicBoolean(false);

    //请求总数
    public static int clientTotal = 5000;
    //同时并发线程数
    public static int threadTotal = 200;
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try{
                    semaphore.acquire();
                    test();
                    semaphore.release();
                }catch (Exception e){
                    log.error("线程错误",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappend:{}",isHappend);
    }

    public static void test(){
        if (isHappend.compareAndSet(false,true)){
            log.info("isHappend{}",isHappend);
        }
    }

}
