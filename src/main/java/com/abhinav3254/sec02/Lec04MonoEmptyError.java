package com.abhinav3254.sec02;

import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    public static void main(String[] args) {
        getUsername(3)
                .subscribe(
                        s-> System.out.println(s),
                        err-> System.out.println("error "+err.getMessage())
                );
    }

    private static Mono<String> getUsername(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("Khushi");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid input"));
        };
    }

}
