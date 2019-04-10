package com.ewing.service_consumer.util;

import com.ewing.service_consumer.client.UserClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory {
    @Override
    public UserClient create(Throwable throwable) {
        return () -> "feign + hystrix ,提供者服务挂了";
    }
}
