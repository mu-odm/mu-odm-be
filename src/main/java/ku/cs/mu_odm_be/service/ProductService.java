package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.repository.ProductRepository;
import ku.cs.mu_odm_be.request.ProductRequest;
import ku.cs.mu_odm_be.response.ProductResponse;
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

    public ProductResponse createProduct (ProductRequest req) {
        Product product = modelMapper.map(req, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductResponse.class);
    }

    public ProductResponse updateProduct(Product prod) {
        Product existingProduct = this.findById(prod.getId());
        if (existingProduct == null) {
            throw new IllegalArgumentException("Product not found with id: " + prod.getId());
        }

        if (prod.getName() != null) {
            existingProduct.setName(prod.getName());
        }
        if (prod.getPrice() != 0) {
            existingProduct.setPrice(prod.getPrice());
        }

        productRepository.save(existingProduct);
        return modelMapper.map(existingProduct, ProductResponse.class);
    }

    public Product findById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }
}
