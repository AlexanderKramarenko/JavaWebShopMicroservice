package ru.alexander_kramarenko.java_web_shop_v11.core.utils;

import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.CategoryDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.OrderDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.OrderItemDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.ProductDto;
import ru.alexander_kramarenko.java_web_shop_v11.core.model.Category;
import ru.alexander_kramarenko.java_web_shop_v11.core.model.Order;
import ru.alexander_kramarenko.java_web_shop_v11.core.model.OrderItem;
import ru.alexander_kramarenko.java_web_shop_v11.core.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {
    public ProductDto productToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.getCategory().getTitle());
    }

    public CategoryDto categoryToDto(Category category) {
        List<ProductDto> products = category.getProducts().stream().map(p -> productToDto(p)).collect(Collectors.toList());
        return new CategoryDto(category.getId(), category.getTitle(), products);
    }

    public OrderItemDto orderItemToDto(OrderItem orderItem) {
        return new OrderItemDto(orderItem.getProduct().getId(), orderItem.getProduct().getTitle(), orderItem.getQuantity(), orderItem.getPricePerProduct(), orderItem.getPrice());
    }

    public OrderDto orderToDto(Order order) {
        return new OrderDto(order.getId(), order.getItems().stream().map(oi -> orderItemToDto(oi)).collect(Collectors.toList()), order.getAddress(), order.getPhone(), order.getPrice());
    }
}
