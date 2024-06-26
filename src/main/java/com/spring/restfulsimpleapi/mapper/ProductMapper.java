package com.spring.restfulsimpleapi.mapper;

import com.spring.restfulsimpleapi.dto.ProductRequest;
import com.spring.restfulsimpleapi.dto.ProductResponse;
import com.spring.restfulsimpleapi.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse mapToProductResponse(Product product);
    Product mapRequestToProduct(ProductRequest productRequest);
}
