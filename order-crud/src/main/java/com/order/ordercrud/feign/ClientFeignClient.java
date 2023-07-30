package com.order.ordercrud.feign;

import com.client.clientcrud.entity.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service",url= "${feign.dependency.client-crud.url}") // Name of the Client Microservice registered with Eureka
public interface ClientFeignClient {

    @GetMapping("/clients/{clientId}")
    Client getClientById(@PathVariable Long clientId);
}
