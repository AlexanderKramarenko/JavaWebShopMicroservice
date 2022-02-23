package ru.alexander_kramarenko.java_web_shop_v11.core.controllers;

import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.OrderDetailsDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.OrderDto;
import ru.alexander_kramarenko.java_web_shop_v11.core.services.OrderService;
import ru.alexander_kramarenko.java_web_shop_v11.core.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
//@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;
    private final Converter converter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDetailsDto orderDetailsDto, @RequestHeader String username) {
        orderService.createOrder(username, orderDetailsDto);
    }

    @GetMapping
    public List<OrderDto> getOrdersForCurrentUser(@RequestHeader String username) {
        return orderService.findAllByUsername(username).stream().map(o -> converter.orderToDto(o)).collect(Collectors.toList());
    }
}
