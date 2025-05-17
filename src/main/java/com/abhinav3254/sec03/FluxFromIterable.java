package com.abhinav3254.sec03;

import com.abhinav3254.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class FluxFromIterable {

    public static void main(String[] args) {

        var list = List.of("a","b","c");

        Flux.fromIterable(list)
                .subscribe(Util.subscriber());

        Integer[] arr = {1,2,3,4,5,6,7,8};

        Flux.fromArray(arr)
                .subscribe(Util.subscriber());

    }

}
