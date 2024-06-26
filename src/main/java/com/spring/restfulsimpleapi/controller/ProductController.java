package com.spring.restfulsimpleapi.controller;

import com.spring.restfulsimpleapi.dto.ProductRequest;
import com.spring.restfulsimpleapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public Map<String,Object> generateResponse(Object data ,String massage , int status) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload",data);
        response.put("message",massage);
        response.put("status",status);
        return response;
    }

    @GetMapping
    public Map<String,Object> getAllProducts() {
        return generateResponse(
                productService.getAllProduct(),
                "Successfully retrieved all the products",
                HttpStatus.OK.value()
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String,Object> addProduct(@RequestBody ProductRequest productRequest) {
        return generateResponse(
                productService.createProduct(productRequest),
                "Successfully create products",
                HttpStatus.CREATED.value()
        );
    }
}
