package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Purchase;
import ku.cs.mu_odm_be.repository.PurchaseRepository;
import ku.cs.mu_odm_be.request.PurchaseRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase findPurchaseById(UUID id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    public List<Purchase> findAllPurchaseByClientId(UUID id) {
        return purchaseRepository.findAllByClientId(id);
    }
    public Purchase findPurchaseByOrderIdAndClientId(UUID orderId, UUID clientId) {
        return purchaseRepository.findByOrderIdAndClientId(orderId, clientId);
    }
}
