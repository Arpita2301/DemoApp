package com.project.example.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInfo {

    private String pname;
    private double noofitems;
    private double price;
    private double discountPrice;
    private double totalDiscount;

}
