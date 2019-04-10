package com.ewing.service_consumer.client;

import com.ewing.service_consumer.util.HystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@EnableFeignClients
@FeignClient(value = "service-provider",fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserClient {

    @GetMapping("/")
    String consumer();
}
