package com.arpanbags.products.arpanbagsproducts.service;


import com.arpanbags.products.arpanbagsproducts.dto.OrderDTO;
import com.arpanbags.products.arpanbagsproducts.dto.OrderItemDTO;
import com.arpanbags.products.arpanbagsproducts.entity.OrderItem;
import com.arpanbags.products.arpanbagsproducts.entity.Orders;
import com.arpanbags.products.arpanbagsproducts.enums.OrderStatus;
import com.arpanbags.products.arpanbagsproducts.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;

    public OrderDTO createOrder(OrderDTO orderDto) {
        Orders order = new Orders();
        order.setOrderDate(orderDto.getOrderDate());
        order.setOrderStatus(OrderStatus.BOOKED);
        order.setUserId(10L);
        order.setOrderNumber("ORDER_ID_" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        order.setItems(setCartItemsDTO(orderDto.getItemsDTOs()));
        orderRepository.save(order);
        return orderDto;
    }

    private List<OrderItem> setCartItemsDTO(List<OrderItemDTO> items) {
        return items.stream().map(itemDTO->{
            OrderItem orderItem = new OrderItem();
            //orderItem.setId(itemDTO.getId());
            orderItem.setPrice(itemDTO.getPrice());
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setProductName(itemDTO.getProductName());
            return orderItem;
        }).collect(Collectors.toList());

    }

    public Optional<Orders> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders updateOrder(Orders order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
