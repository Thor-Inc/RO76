package pl.sda.spring.springdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class OrderInit implements CommandLineRunner {

    private final OrderRepository orderRepository;

    public OrderInit(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        final Order orderA = new Order("NEW", 20.0, new Date(System.currentTimeMillis()), "CARD");
        final Order orderB = new Order("ACTIVE", 22.0, new Date(System.currentTimeMillis()), "CARD");
        orderRepository.save(orderA);
        orderRepository.save(orderB);
    }
}