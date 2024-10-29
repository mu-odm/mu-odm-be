package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.*;
import ku.cs.mu_odm_be.repository.PPSRepository;
import ku.cs.mu_odm_be.repository.ProductRepository;
import ku.cs.mu_odm_be.repository.ProductSizeRepository;
import ku.cs.mu_odm_be.request.PPSRequest;
import ku.cs.mu_odm_be.response.PPSResponse;
import ku.cs.mu_odm_be.response.PurchaseProductResponse;
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
        PPS pps = new PPS();
        pps.setId(new PPSKey(req.getProduct_id(), req.getProduct_size_id()));
        pps.setProduct(productRepository.findById(req.getProduct_id()).get());
        pps.setProduct_size(productSizeRepository.findById(req.getProduct_size_id()).get());

        return modelMapper.map(ppsRepository.save(pps), PPSResponse.class);

    }

    public List<PPSResponse> getAllPPS() {
        List<PPS> ppsList = ppsRepository.findAll();
        return ppsList.stream().map(pps -> modelMapper.map(pps, PPSResponse.class)).toList();
    }

    public List<PPSResponse> getAllSizeByProduct(UUID product_id) {
        List<PPS> ppsList = ppsRepository.findByProductId(product_id);
        return ppsList.stream().map(pps -> modelMapper.map(pps, PPSResponse.class)).toList();
    }


}
