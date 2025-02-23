package com.sda.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private  int stock;
    private double price;

}
