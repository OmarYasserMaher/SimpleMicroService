package com.product.productcrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save three different products
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(10.99);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(19.95);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setPrice(7.50);
        productRepository.save(product3);

        System.out.println("Three products have been created and saved.");
    }
}
