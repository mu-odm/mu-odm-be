package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Purchase;
import ku.cs.mu_odm_be.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository PurchaseRepository;

    public Purchase creatPurchase(Purchase purchase) {
        return PurchaseRepository.save(purchase);
    }
}
