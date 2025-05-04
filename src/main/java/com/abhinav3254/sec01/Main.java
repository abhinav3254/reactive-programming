package com.abhinav3254.sec01;

import com.abhinav3254.sec01.publisher.PublisherImpl;
import com.abhinav3254.sec01.publisher.SubscriptionImpl;
import com.abhinav3254.sec01.subscriber.SubscriberImpl;

public class Main {

    public static void main(String[] args) {

        demo1();

    }

    private static void demo1() {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(5);
        System.out.println("-----");
        subscriber.getSubscription().request(3);
        System.out.println("-----");
        subscriber.getSubscription().request(1);
        System.out.println("-----");
        subscriber.getSubscription().request(2);
        System.out.println("-----");
        subscriber.getSubscription().request(4);
    }

}
