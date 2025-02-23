package com.sda.demo.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "users")
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name="phone")
    private String phoneNumber;
    @Column(name="role")
    private String role;
    @Column(name="address")
    private String address;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @Column(name="username")
    private String username;

    public User() {
    }
    public User(String firstName, String lastName, String phoneNumber, String role, String address, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.role = role;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
