package com.example.productmicroservice.converter;

import com.example.productmicroservice.model.entity.Product;
import com.example.productmicroservice.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    public ProductDto fill(Product source) {
        return new ProductDto()
                .setId(source.getId())
                .setName(source.getName())
                .setActive(source.getActive());
    }
}
