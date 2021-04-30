package com.project.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Items {

    @Id
    @Column(name = "item_id")
    private String itemId;

    @Column(name = "p_name")
    private String pName;

    @Column(name = "no_of_items")
    private Double noOfItems;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount_price")
    private Double discountPrice;

    @Column(name = "total_discount")
    private Double totalDiscount;


}
