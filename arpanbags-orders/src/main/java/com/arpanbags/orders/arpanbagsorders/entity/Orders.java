package com.arpanbags.orders.arpanbagsorders.entity;


import com.arpanbags.orders.arpanbagsorders.dto.ProductsTypeDTO;
import com.arpanbags.orders.arpanbagsorders.dto.RestaurantDTO;
import com.arpanbags.orders.arpanbagsorders.dto.UsersDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("orders")
public class Orders {
    private Long orderId;
    private List<ProductsTypeDTO> productsTypeDTOS;
    private List<RestaurantDTO>  restaurantDTOS;
    private UsersDTO usersDTO;
}
