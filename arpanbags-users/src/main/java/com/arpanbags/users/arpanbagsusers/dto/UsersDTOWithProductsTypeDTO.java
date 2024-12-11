package com.arpanbags.users.arpanbagsusers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTOWithProductsTypeDTO {

    private UsersDTO usersDTO;

    private ProductsTypeDTO productsTypeDTO;
}
