
package com.delivery.delivery.service;

import com.delivery.delivery.foot.Foot;
import com.delivery.delivery.order.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private List<Foot> footsAvailable;


    public List<Foot> getfootsAvailable(Foot foot) {
        this.footsAvailable = new ArrayList<>();
        this.footsAvailable.add(foot);
        return footsAvailable;
    }

    public int makeOrder(Order order) {
        int orderId = orders.size() + 1;
        order.setId(orderId);
        String status = "En proceso";
        order.setStatus(status);
        LocalDateTime creationTime = LocalDateTime.now();
        order.setCreationTime(creationTime);
        LocalDateTime estimatedDeliveryTime = creationTime.plusMinutes(45);
        order.setEstimatedDeliveryTime(estimatedDeliveryTime);
        orders.add(order);
        return order.getId();
    }

    public Order getOrder(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public List<Foot> getMenuAvailable() {
        return footsAvailable;
    }
}
