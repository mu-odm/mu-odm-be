package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Client;
import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.repository.ProductRepository;
import ku.cs.mu_odm_be.request.ProductRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Product createProduct (ProductRequest req) {
        Product product = modelMapper.map(req, Product.class);
        return productRepository.save(product); }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }
}
