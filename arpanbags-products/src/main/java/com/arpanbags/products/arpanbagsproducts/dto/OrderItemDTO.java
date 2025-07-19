package com.arpanbags.products.arpanbagsproducts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long id;
    private String productName;
    private int quantity;
    private double price;
    private String orderNumber;
}
