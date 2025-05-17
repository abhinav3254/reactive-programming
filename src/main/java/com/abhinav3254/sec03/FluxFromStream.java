package com.abhinav3254.sec03;

import com.abhinav3254.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class FluxFromStream {

    public static void main(String[] args) {

        var list = List.of(1,2,3,4);

        var stream = list.stream();

        var flux = Flux.fromStream(list::stream);

        flux.subscribe(Util.subscriber("sub01"));
        flux.subscribe(Util.subscriber("sub02"));

        Flux.range(1,10)
                .map(i->Util.getFaker().name().firstName())
                .subscribe(Util.subscriber());

    }

}
