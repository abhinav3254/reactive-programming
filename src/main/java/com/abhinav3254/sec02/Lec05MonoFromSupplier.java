package com.abhinav3254.sec02;

import com.abhinav3254.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec05MonoFromSupplier {

    private static final Logger log = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);

    public static void main(String[] args) {

        var list = List.of(1,2,3);
        // If u want to delay the compute intensive operation then you can use fromSupplier
        Mono.fromSupplier(()->sum(list))
                .subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list) {
        log.info("Finding the sum of the list {}",list);
        return list.stream().mapToInt(value -> value).sum();
    }

}
