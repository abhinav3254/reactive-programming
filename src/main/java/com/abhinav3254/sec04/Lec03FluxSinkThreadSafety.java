package com.abhinav3254.sec04;

import com.abhinav3254.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Lec03FluxSinkThreadSafety {

    public static final Logger logger = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        // this show it is not thread safe
        var list = new ArrayList<Integer>();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleepSeconds(5);
        logger.info("size of this list {}",list.size());
    }
}
