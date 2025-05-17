package com.abhinav3254.sec03;

import com.abhinav3254.common.Util;
import reactor.core.publisher.Flux;

public class MultipleSubscribers {

    public static void main(String[] args) {
        var flux = Flux.just(1,2,3,4,5,6);
        flux.subscribe(Util.subscriber("subscriber-1"));
        flux.subscribe(Util.subscriber("subscriber-2"));
        flux
                .filter(i-> i % 2 == 0)
                .map(i->i+"a")
                .subscribe(Util.subscriber("subscriber-3"));
    }

}
