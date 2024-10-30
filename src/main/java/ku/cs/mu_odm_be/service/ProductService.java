package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.common.Status;
import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.repository.ProductRepository;
import ku.cs.mu_odm_be.request.ProductRequest;
import ku.cs.mu_odm_be.response.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse createProduct (ProductRequest req) {
        Product product = modelMapper.map(req, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductResponse.class);
    }

    public ProductResponse updateProduct(UUID productID, ProductRequest req) {
        ProductResponse res = getProduct(productID);

        if (res == null) {
            throw new IllegalArgumentException("Product not found with id: " + productID);
        }

        if (req.getName() != null) {
            res.setName(req.getName());
        }
        if (req.getPrice() != 0) {
            res.setPrice(req.getPrice());
        }

        Product existingProduct = modelMapper.map(res, Product.class);
        productRepository.save(existingProduct);
        return modelMapper.map(existingProduct, ProductResponse.class);
    }

    public List<ProductResponse> getAllProducts() {
        return modelMapper.map(productRepository.findAll(), List.class);
    }

    public ProductResponse getProduct(UUID id) {
        return modelMapper.map(productRepository.findById(id).orElse(null), ProductResponse.class);
    }

    public List<ProductResponse> getProductByName(String name) {
        List<Product> products = productRepository.findByName(name);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .collect(java.util.stream.Collectors.toList());
    }

}
