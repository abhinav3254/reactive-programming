package com.abhinav3254.sec02.client;

import com.abhinav3254.common.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    public Mono<String> getProductName(int productId) {
        return this.httpClient.get().uri("/demo01/product/"+productId)
                .responseContent()
                .asString()
                .next();

    }

}
