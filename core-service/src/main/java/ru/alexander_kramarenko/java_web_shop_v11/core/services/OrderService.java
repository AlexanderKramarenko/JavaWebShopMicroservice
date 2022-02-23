package ru.alexander_kramarenko.java_web_shop_v11.core.services;

import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.CartDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.OrderDetailsDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.OrderItemDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.exceptions.ResourceNotFoundException;
import ru.alexander_kramarenko.java_web_shop_v11.core.integration.CartServiceIntegration;
import ru.alexander_kramarenko.java_web_shop_v11.core.model.*;
import ru.alexander_kramarenko.java_web_shop_v11.core.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartServiceIntegration cartServiceIntegration;
    private final ProductService productService;

    @Transactional
    public void createOrder(String username, OrderDetailsDto orderDetailsDto) {
        CartDto cart = cartServiceIntegration.getUserCartDto(username);
        Order order = new Order();
        order.setUsername(username);
        order.setPrice(cart.getTotalPrice());
        order.setAddress(orderDetailsDto.getAddress());
        order.setPhone(orderDetailsDto.getPhone());
        List<OrderItem> items = new ArrayList<>();
        for (OrderItemDto i : cart.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setPrice(i.getPrice());
            orderItem.setPricePerProduct(i.getPricePerProduct());
            orderItem.setQuantity(i.getQuantity());
            orderItem.setProduct(productService.findById(i.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Не удалось найти продукт при оформлении заказа. ID продукта: " + i.getProductId())));
            items.add(orderItem);
        }
        order.setItems(items);
        orderRepository.save(order);
        cartServiceIntegration.clearUserCart(username);
    }

    public List<Order> findAllByUsername(String username) {
        return orderRepository.findAllByUsername(username);
    }
}
