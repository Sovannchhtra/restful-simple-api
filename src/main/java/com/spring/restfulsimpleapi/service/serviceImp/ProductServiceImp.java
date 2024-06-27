package com.spring.restfulsimpleapi.service.serviceImp;

import com.spring.restfulsimpleapi.dto.ProductRequest;
import com.spring.restfulsimpleapi.dto.ProductResponse;
import com.spring.restfulsimpleapi.entity.Product;
import com.spring.restfulsimpleapi.mapper.ProductMapper;
import com.spring.restfulsimpleapi.repository.ProductRepository;
import com.spring.restfulsimpleapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        // find product by id
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // set new value product
            product.setTitle(productRequest.title());
            product.setDescription(productRequest.description());
            product.setPrice(productRequest.price());
            product.setImageUrl(productRequest.imageUrl());

            // save product update
            return productMapper.mapToProductResponse(productRepository.save(product));
        }else {
            return null;
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
