package ku.cs.mu_odm_be.controller;

import ku.cs.mu_odm_be.entity.Purchase;
import ku.cs.mu_odm_be.response.PurchaseResponse;
import ku.cs.mu_odm_be.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public List<PurchaseResponse> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/purchase")
    public PurchaseResponse getPurchase(@RequestParam UUID purchaseID) {
        return purchaseService.getPurchase(purchaseID);
    }
}
