package ku.cs.mu_odm_be.service;

import ku.cs.mu_odm_be.common.Status;
import ku.cs.mu_odm_be.entity.Order;
import ku.cs.mu_odm_be.entity.User;
import ku.cs.mu_odm_be.repository.OrderRepository;
import ku.cs.mu_odm_be.request.OrderRequest;
import ku.cs.mu_odm_be.response.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Order createOrder(User user) {
        Order order = new Order();
        order.setStatus(Status.available);
        order.setUser(user);

        return orderRepository.save(order);
    }

    public List<OrderResponse> getAllOrders() {
        return modelMapper.map(orderRepository.findAll(), List.class);
    }

    public OrderResponse getOrder(UUID orderID) {
        return modelMapper.map(orderRepository.findById(orderID).get(), OrderResponse.class);
    }

    public Order getExistOrder(Status status, String region) {
        return orderRepository.findByRegionAndStatus(region, status);
    }

    public OrderResponse updateOrder(UUID orderID, OrderRequest req) {
        Order currentOrder = orderRepository.findById(orderID).get();
        currentOrder.setStatus(req.getStatus());
        return modelMapper.map(orderRepository.save(currentOrder), OrderResponse.class);
    }
}
