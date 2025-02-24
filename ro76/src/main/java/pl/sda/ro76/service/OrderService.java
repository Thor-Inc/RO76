package pl.sda.ro76.service;

import org.springframework.stereotype.Service;
import pl.sda.ro76.model.Order;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    List<Order> orderList = new ArrayList<>();
    int id = 0;

    public void addOrder(Order order) {
        order.setId(id);
        order.setStatus("ACTIVE");
        order.setDate(new Date());
        order.setPaymentMethod("CARD");
        orderList.add(order);
        id++;
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

}