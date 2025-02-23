package pl.sda.spring.springdata;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private double total;
    private Date date;
    private String payment_method;

    public Order(String status, double total, Date date, String payment_method) {
        this.status = status;
        this.total = total;
        this.date = date;
        this.payment_method = payment_method;
    }
}