package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Order;
import ku.cs.mu_odm_be.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {return orderRepository.save(order);}
}
