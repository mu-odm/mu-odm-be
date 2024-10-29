package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.PPS;
import ku.cs.mu_odm_be.entity.PPSKey;
import ku.cs.mu_odm_be.entity.Product;
import ku.cs.mu_odm_be.entity.ProductSize;
import ku.cs.mu_odm_be.repository.PPSRepository;
import ku.cs.mu_odm_be.repository.ProductRepository;
import ku.cs.mu_odm_be.repository.ProductSizeRepository;
import ku.cs.mu_odm_be.request.PPSRequest;
import ku.cs.mu_odm_be.response.PPSResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PPSService {

    @Autowired
    private PPSRepository ppsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSizeRepository productSizeRepository;

    public PPSResponse createPPS(PPSRequest req) {
        PPS pps = modelMapper.map(req, PPS.class);

        Product product = productRepository.findById(req.getProduct_id()).orElse(null);
        pps.setProduct(product);
        ProductSize productSize = productSizeRepository.findById(req.getProduct_size_id()).orElse(null);
        pps.setProduct_size(productSize);

        pps.setId(new PPSKey(req.getProduct_id(), req.getProduct_size_id()));

        ppsRepository.save(pps);
        return modelMapper.map(pps, PPSResponse.class);
    }

    public List<PPSResponse> getAllPPS() {
        List<PPS> ppsList = ppsRepository.findAll();
        return ppsList.stream()
                .map(pps -> modelMapper.map(pps, PPSResponse.class))
                .toList();
    }

    public List<PPSResponse> getAllSizeByProduct(UUID product_id) {
        List<PPS> ppsList = ppsRepository.findAllByProductID(product_id);
        return ppsList.stream()
                .map(pps -> modelMapper.map(pps, PPSResponse.class))
                .toList();
    }


}
