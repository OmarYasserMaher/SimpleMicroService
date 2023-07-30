package com.product.productcrud;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // find products by ids
    List<Product> findAllByIdIn(List<Long> ids);
}
