package com.tangjiqunliu.concurrency.example.publish;

import com.tangjiqunliu.concurrency.annoations.NoThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@NoThreadSafe
@Slf4j
public class UnSafePublish {

    private String[] status = {"a","b","c"};

    public String[] getStatus(){
        return status;
    }


    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("status[]{}", Arrays.toString(unSafePublish.getStatus()));
        unSafePublish.getStatus()[0] = "d";
        log.info("status[]{}", Arrays.toString(unSafePublish.getStatus()));
    }
}
