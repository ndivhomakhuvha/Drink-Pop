package com.birimarung.controllers;

import com.birimarung.dto.ProductDTO;
import com.birimarung.dto.RestResponse;
import com.birimarung.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping("/all")
    public RestResponse<List<ProductDTO>> getAllProductsController() {
        return productsService.getAllProducts();
    }

    @GetMapping("/all/{drink_name}")
    public RestResponse<List<ProductDTO>> getDrinksOfCertainName(@PathVariable String drink_name) {
        return productsService.getAllDrinksByName(drink_name);
    }
}
