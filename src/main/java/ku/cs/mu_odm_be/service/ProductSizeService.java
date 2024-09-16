package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.ProductSize;
import ku.cs.mu_odm_be.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductSizeService {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    public ProductSize createProductSize(ProductSize productSize) { return productSizeRepository.save(productSize); }

    public ProductSize findById(UUID id) {
        return productSizeRepository.findById(id).get();
    }
}
