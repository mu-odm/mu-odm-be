package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Purchase;
import ku.cs.mu_odm_be.repository.PurchaseRepository;
import ku.cs.mu_odm_be.request.PurchaseRequest;
import ku.cs.mu_odm_be.response.PurchaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PurchaseResponse> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases.stream()
                .map(purchase -> {
                    PurchaseResponse response = modelMapper.map(purchase, PurchaseResponse.class);
                    response.setClientID(purchase.getClient().getId());
                    response.setOrderID(purchase.getOrder().getId());
                    return response;
                })
                .collect(Collectors.toList());
    }

    public PurchaseResponse getPurchase(UUID purchaseID) {
        return modelMapper.map(purchaseRepository.findById(purchaseID).get(), PurchaseResponse.class);
    }

    public List<Purchase> getAllPurchaseByClientId(UUID id) {
        return purchaseRepository.findAllByClientId(id);
    }
    public Purchase getPurchaseByOrderIdAndClientId(UUID orderId, UUID clientId) {
        return purchaseRepository.findByOrderIdAndClientId(orderId, clientId);
    }
}
