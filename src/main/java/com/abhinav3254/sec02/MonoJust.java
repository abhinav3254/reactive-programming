package com.abhinav3254.sec02;

import com.abhinav3254.sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

public class MonoJust {

    public static void main(String[] args) {
        Publisher<String> mono =  Mono.just("Abhinav");
        System.out.println(mono);

        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(10);

    }

}
