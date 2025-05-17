package com.abhinav3254.sec03;

import com.abhinav3254.common.Util;
import reactor.core.publisher.Flux;

public class FluxJust {

    public static void main(String[] args) {
        Flux.just(1,2,3,4,5,6,7,8,9,10)
                .subscribe(Util.subscriber());
    }

}
