package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Order;
import ku.cs.mu_odm_be.entity.Purchase;
import ku.cs.mu_odm_be.repository.PurchaseRepository;
import ku.cs.mu_odm_be.request.PurchaseRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository PurchaseRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    public Purchase creatPurchase(PurchaseRequest req) {
        Purchase purchase = modelMapper.map(req, Purchase.class);
        Order order = orderService.findById(req.getOrder_id());
        purchase.setOrder(order);
        return PurchaseRepository.save(purchase);
    }
}
