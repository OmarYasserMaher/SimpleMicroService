package com.order.ordercrud.feign;

import com.product.productcrud.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service",url="${feign.dependency.product-crud.name}") // Name of the Product Microservice registered with Eureka
public interface ProductFeignClient {

    @GetMapping("/products/{Id}")
    Product getProductById(@PathVariable Long Id);

    @GetMapping("/products/ids")
    List<Product> findAllByIds(@RequestParam List<Long> ids);
}
