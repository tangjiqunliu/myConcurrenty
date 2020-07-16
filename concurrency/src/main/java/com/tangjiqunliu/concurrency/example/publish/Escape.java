package com.tangjiqunliu.concurrency.example.publish;

import com.tangjiqunliu.concurrency.annoations.NoThreadSafe;
import com.tangjiqunliu.concurrency.annoations.NotReCommend;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoThreadSafe
@NotReCommend
public class Escape {

    private int thisCanEscape = 0;

    public Escape(){
        new innerEscape();
    }

    private class innerEscape{
        public innerEscape(){
            log.info("{}",Escape.this.thisCanEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
