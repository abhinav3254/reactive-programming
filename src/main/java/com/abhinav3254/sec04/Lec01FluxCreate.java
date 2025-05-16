package com.abhinav3254.sec04;

import com.abhinav3254.common.Util;
import reactor.core.publisher.Flux;


/**
 * To create a flux & emit items programmatically
 */
public class Lec01FluxCreate {

    public static void main(String[] args) {
//        Flux.create(fluxSink -> {
//            int n = 0;
//            while (n<10) {
//                fluxSink.next(Util.getFaker().country().name());
//                n++;
//            }
//            fluxSink.complete();
//        })
//        .subscribe(Util.subscriber());

        Flux.create(fluxSink -> {
            String country;
            do  {
                country = Util.getFaker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada"));
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }

}
