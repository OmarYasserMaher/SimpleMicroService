package com.order.ordercrud;

import com.client.clientcrud.entity.Client;
import com.product.productcrud.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    //Client
    private Client client;

    //Product
    private List<Product> products;

    private Double total;

}
