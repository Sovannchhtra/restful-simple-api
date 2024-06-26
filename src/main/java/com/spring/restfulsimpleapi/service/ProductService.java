package com.spring.restfulsimpleapi.service;


import com.spring.restfulsimpleapi.dto.ProductRequest;
import com.spring.restfulsimpleapi.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAllProduct();
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(Long id,ProductRequest product);
    void deleteProduct(Long id);
}
