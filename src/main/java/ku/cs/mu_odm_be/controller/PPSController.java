package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.PPS;
import ku.cs.mu_odm_be.request.PPSRequest;
import ku.cs.mu_odm_be.request.PurchaseProductRequest;
import ku.cs.mu_odm_be.response.PPSResponse;
import ku.cs.mu_odm_be.response.PurchaseProductResponse;
import ku.cs.mu_odm_be.service.PPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pps")
public class PPSController {

    @Autowired
    PPSService ppsService;

    @PostMapping
    public PPSResponse createPPS (@RequestBody PPSRequest req, BindingResult result) {

        if (result.hasErrors())
            return null;

        return ppsService.createPPS(req);
    }

    @GetMapping
    public List<PPSResponse> getAllPPS() {
        return ppsService.getAllPPS();
    }

    @GetMapping("/product")
    public List<PPSResponse> getAllSizeByProduct(@RequestParam UUID product_id) {
        return ppsService.getAllSizeByProduct(product_id);
    }
}
