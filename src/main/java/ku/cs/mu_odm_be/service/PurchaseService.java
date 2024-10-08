package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Purchase;
import ku.cs.mu_odm_be.repository.PurchaseRepository;
import ku.cs.mu_odm_be.request.PurchaseRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Purchase creatPurchase(PurchaseRequest req) {
        Purchase purchase = modelMapper.map(req, Purchase.class);
        purchaseRepository.save(purchase);
        return purchase;
    }
    public Purchase findPurchaseById(UUID id) {
        return purchaseRepository.findById(id).orElse(null);
    }
    public Purchase findPurchaseByClientId(UUID id) {
        return purchaseRepository.findByClientId(id);
    }
    public Purchase findPurchaseByOrderIdAndClientId(UUID orderId, UUID clientId) {
        return purchaseRepository.findByOrderIdAndClientId(orderId, clientId);
    }
}
