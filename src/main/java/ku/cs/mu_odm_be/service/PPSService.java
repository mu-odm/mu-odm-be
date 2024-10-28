package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.PPS;
import ku.cs.mu_odm_be.repository.PPSRepository;
import ku.cs.mu_odm_be.request.PPSRequest;
import ku.cs.mu_odm_be.response.PPSResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PPSService {

    @Autowired
    private PPSRepository ppsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PPSResponse createPPS(PPSRequest req) {
        PPS pps = modelMapper.map(req, PPS.class);
        return modelMapper.map(ppsRepository.save(pps), PPSResponse.class);
    }

    public List<PPSResponse> getAllPPS() {
        List<PPS> ppsList = ppsRepository.findAll();
        return ppsList.stream()
                .map(pps -> modelMapper.map(pps, PPSResponse.class))
                .toList();
    }

}
