package com.abhinav3254.sec01.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);

    private final Subscriber<? super String> subscriber;

    private boolean isCanceled;
    private final Faker faker;
    public static final int MAX_ITEMS = 10;
    public static int count = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long request) {
        if (!isCanceled) {
            log.info("subscriber have requested {} items",request);
            for (int i = 0; i<request && count < MAX_ITEMS; i++) {
                count++;
                this.subscriber.onNext(this.faker.internet().emailAddress());
            }
            if (count == MAX_ITEMS) {
                log.info("no more data to produce");
                this.subscriber.onComplete();
                this.isCanceled = true;
            }
        } else {
            return;
        }
    }

    @Override
    public void cancel() {
        log.info("subscriber have cancelled");
        this.isCanceled = true;
    }
}
