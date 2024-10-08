package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.entity.ProductSize;
import ku.cs.mu_odm_be.repository.ProductSizeRepository;
import ku.cs.mu_odm_be.request.ProductSizeRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductSizeService {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;

    public ProductSizeRequest createProductSize(ProductSizeRequest req) {
        ProductSize productSize = modelMapper.map(req, ProductSize.class);
        Product product = productService.findById(req.getProduct_id());
        productSize.setProduct(product);
        productSizeRepository.save(productSize);
        return req;
    }

    public ProductSize findById(UUID id) {
        return productSizeRepository.findById(id).get();
    }
}
