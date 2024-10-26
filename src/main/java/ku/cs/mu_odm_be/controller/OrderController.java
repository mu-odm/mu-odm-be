package ku.cs.mu_odm_be.controller;
import ku.cs.mu_odm_be.entity.Order;
import ku.cs.mu_odm_be.request.OrderRequest;
import ku.cs.mu_odm_be.response.OrderResponse;
import ku.cs.mu_odm_be.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order")
    public OrderResponse getOrder(@RequestParam UUID orderID) {
        return orderService.getOrder(orderID);
    }

    @PutMapping("/order")
    public OrderResponse updateOrder(@RequestParam UUID orderID, @RequestBody OrderRequest req) {
        return orderService.updateOrder(orderID, req);
    }

}
