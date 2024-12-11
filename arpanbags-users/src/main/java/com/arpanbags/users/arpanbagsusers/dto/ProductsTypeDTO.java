package com.arpanbags.users.arpanbagsusers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsTypeDTO {
    private Long Id;
    private String productType;
    private String productName;

}
