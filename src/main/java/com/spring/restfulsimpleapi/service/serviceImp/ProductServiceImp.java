package com.spring.restfulsimpleapi.service.serviceImp;

import com.spring.restfulsimpleapi.dto.ProductRequest;
import com.spring.restfulsimpleapi.dto.ProductResponse;
import com.spring.restfulsimpleapi.mapper.ProductMapper;
import com.spring.restfulsimpleapi.repository.ProductRepository;
import com.spring.restfulsimpleapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToProductResponse)
                .toList();
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        return productMapper.mapToProductResponse(
                productRepository.save(
                        productMapper.mapRequestToProduct(productRequest)
                )
        );
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
