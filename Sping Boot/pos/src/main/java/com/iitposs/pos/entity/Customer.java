package com.iitposs.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;

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
}
