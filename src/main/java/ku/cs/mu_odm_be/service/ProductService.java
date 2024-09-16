package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct (Product product) { return productRepository.save(product); }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }
}
