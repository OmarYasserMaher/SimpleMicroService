package com.order.ordercrud;

import com.order.ordercrud.feign.ClientFeignClient;
import com.order.ordercrud.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    private final ProductFeignClient productFeignClient;
    private final ClientFeignClient clientFeignClient;

    @Autowired
    public OrderMapper(ProductFeignClient productFeignClient, ClientFeignClient clientFeignClient) {
        this.productFeignClient = productFeignClient;
        this.clientFeignClient = clientFeignClient;
    }

    //Order to OrderDTO
    public  OrderDTO toDTO(Orders order){
        return new OrderDTO(
                order.getId(),
                clientFeignClient.getClientById(order.getClientId()),
                productFeignClient.findAllByIds(order.getProductIds()),
                order.getTotal()
        );
    }
    //list of Orders to list of OrderDTO
    public  List<OrderDTO> toDTO(List<Orders> orders){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Orders order: orders){
            orderDTOS.add(toDTO(order));
        }
        return orderDTOS;
    }
}
