package com.iitposs.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")
@TypeDef(name = "json", typeClass = JsonType.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", length = 10)
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", nullable = false)
    private String customerAddress;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "contact", columnDefinition = "json")
    @Type(type = "json")
    private ArrayList contacts;

    @Column(name = "nic", nullable = false)
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    public Customer(int customerId, String customerName, String customerAddress, double salary, ArrayList contacts, String nic, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.salary = salary;
        this.contacts = contacts;
        this.nic = nic;
        this.activeState = activeState;
    }

    @OneToMany(mappedBy = "customer")
    private Set<Orders> orders;

}
