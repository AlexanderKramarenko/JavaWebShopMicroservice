package ru.alexander_kramarenko.java_web_shop_v11.core.controllers;

import org.springframework.web.bind.annotation.*;
import ru.alexander_kramarenko.java_web_shop_v11.api.dtos.CategoryDto;
import ru.alexander_kramarenko.java_web_shop_v11.api.exceptions.ResourceNotFoundException;
import ru.alexander_kramarenko.java_web_shop_v11.core.services.CategoryService;
import ru.alexander_kramarenko.java_web_shop_v11.core.utils.Converter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
//@CrossOrigin("*")
public class CategoryController {
    private final CategoryService categoryService;
    private final Converter converter;

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return converter.categoryToDto(categoryService.findByIdWithProducts(id).orElseThrow(() -> new ResourceNotFoundException("Category id = " + id + " not found")));
    }
}
