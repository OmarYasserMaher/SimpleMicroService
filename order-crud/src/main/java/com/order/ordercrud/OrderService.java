package com.order.ordercrud;

import com.client.clientcrud.entity.Client;
import com.order.ordercrud.feign.ClientFeignClient;
import com.order.ordercrud.feign.ProductFeignClient;
import com.product.productcrud.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    // Feign Clients for communication with Client and Product Microservices
    private final ClientFeignClient clientFeignClient;
    private final ProductFeignClient productFeignClient;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        ClientFeignClient clientFeignClient,
                        ProductFeignClient productFeignClient) {
        this.orderRepository = orderRepository;
        this.clientFeignClient = clientFeignClient;
        this.productFeignClient = productFeignClient;
    }

    public Orders createOrder(Orders order) {
        // Here, you can use Feign Clients to get client and product data from their respective microservices
        // and perform any additional processing related to the order creation.
        // For example:
        List<Product> products = productFeignClient.findAllByIds(order.getProductIds());
        order.setTotal(products.stream().mapToDouble(Product::getPrice).sum());
        // Process client and product data, and save the order to the Order Microservice's database
        // ...
        return orderRepository.save(order);
    }

    public Orders getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);

    }

    public List<Orders> getAllOrders() {
        // Implement logic to retrieve all orders from the Order Microservice's database
        // ...
        return orderRepository.findAll();
    }
}
