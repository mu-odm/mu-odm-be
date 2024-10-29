package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.entity.ProductSize;
import ku.cs.mu_odm_be.repository.ProductRepository;
import ku.cs.mu_odm_be.repository.ProductSizeRepository;
import ku.cs.mu_odm_be.request.ProductSizeRequest;
import ku.cs.mu_odm_be.response.ProductSizeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductSizeService {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    public ProductSizeResponse createProductSize(ProductSizeRequest req) {
        ProductSize productSize = modelMapper.map(req, ProductSize.class);
        productSizeRepository.save(productSize);
        ProductSizeResponse response = modelMapper.map(productSize, ProductSizeResponse.class);

        return response;
    }

    public ProductSize findById(UUID id) {
        return productSizeRepository.findById(id).get();
    }

    public List<ProductSizeResponse> getAllProductSizes() {
        List<ProductSize> productSizes = productSizeRepository.findAll();
        return productSizes.stream()
                .map(productSize -> modelMapper.map(productSize, ProductSizeResponse.class))
                .collect(java.util.stream.Collectors.toList());
    }

    public void deleteProductSize(UUID id) {
        productSizeRepository.deleteById(id);
    }
}
