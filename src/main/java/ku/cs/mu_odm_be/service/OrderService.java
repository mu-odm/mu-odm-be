package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.entity.Order;
import ku.cs.mu_odm_be.repository.OrderRepository;
import ku.cs.mu_odm_be.request.OrderRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Order createOrder(OrderRequest req) {
        Order order = modelMapper.map(req, Order.class);
        return orderRepository.save(order);
    }

    public Order findById(UUID id) {
        return orderRepository.findById(id).orElse(null);
    }
}
