package com.example.newspring.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ItemsTable")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;
    @Column(name = "plant")
    private String plant;
    @Column(name = "inv_number")
    private String invNumber;
    @Column(name = "account_number")
    private String accNumber;
    @Column(name = "item_name")
    private String item_name;
    @Column(name = "item_barand")
    private String item_brand;
    @Column(name = "item_model")
    private String item_model;
    @Column(name = "serial_number", unique = true)
    private String serialnumber;
    @Column(name = "location")
    private String location;
    @Column(name = "hostname")
    private String hostname;
    @Column(name = "ip_address")
    private String ip_address;
    @Column(name = "isDamaged")
    private Boolean isDamaged;
    @Column(name = "user_name")
    private String user_name;
    @Column(name="departmetn")
    private String department;
    @Column(name = "operator_namber")
    private String operator_number;
    @Column(name = "user_added")
    private String user_added_item;


}
