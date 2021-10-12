package com.example.productmicroservice.controller;

import com.example.productmicroservice.model.dto.ProductDto;
import com.example.productmicroservice.model.entity.Product;
import com.example.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-product")
    public ResponseEntity<ProductDto> getProduct(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

    @PostMapping("/create-product")
    public void createProduct(@RequestParam("name") String name) {
        productService.createProduct(name);
    }

    @PostMapping("/change-activity")
    public void changeActivity(@RequestParam("status") Boolean status,
                                @RequestParam("id") Long id) {
        productService.changeActivity(status, id);
    }

    @PostMapping("/add-quantity")
    public void addActivity(@RequestParam("quantity") Long quantity,
                               @RequestParam("id") Long id) {
        productService.addQuantity(quantity, id);
    }

    @PostMapping("/delete-quantity")
    public void deleteQuantity(@RequestParam("quantity") Long quantity,
                            @RequestParam("id") Long id) {
        productService.deleteQuantity(quantity, id);
    }
}
