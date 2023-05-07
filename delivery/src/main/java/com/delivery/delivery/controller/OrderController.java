
package com.delivery.delivery.controller;

import com.delivery.delivery.foot.Foot;
import com.delivery.delivery.order.Order;
import com.delivery.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/menu")
    public ResponseEntity<List<Foot>> getMenu(){
        List<Foot> menu = orderService.getMenuAvailable();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }
    @PostMapping("/foots")
    public ResponseEntity<List<Foot>> getFootsAvailable(@RequestBody Foot foot) {
        List<Foot> foots = orderService.getfootsAvailable(foot);
        return new ResponseEntity<>(foots,HttpStatus.CREATED);
    }
    @PostMapping("/order")
    public ResponseEntity<Integer> makeOrder(@RequestBody Order order){
        int idOrder = orderService.makeOrder(order);
    return new ResponseEntity<>(idOrder,HttpStatus.CREATED);
    }
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable int orderId){
        Order order = orderService.getOrder(orderId);
        if (order != null){
            return new ResponseEntity<>(order, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> gerAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


}
