package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.common.Status;
import ku.cs.mu_odm_be.entity.Order;
import ku.cs.mu_odm_be.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder() {
        Order order = new Order();
        order.setStatus(Status.available);
        return orderRepository.save(order);
    }

    public Order findById(UUID id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order findByStatus(Status status) {
        return orderRepository.findByStatus(status);
    }
}
