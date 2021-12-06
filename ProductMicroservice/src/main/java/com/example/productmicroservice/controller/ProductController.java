package com.example.productmicroservice.controller;

import com.example.productmicroservice.model.Product;
import com.example.productmicroservice.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-product")
    @ApiOperation(value = "Get product by id")
    public ResponseEntity<Product> getProduct(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

    @GetMapping("/get-product-name")
    @ApiOperation(value = "Get product name")
    public String getProductName(@RequestParam("id") Long id) {
        return productService.getProductName(id);
    }

    @PostMapping("/create-product")
    @ApiOperation(value = "Create new product")
    public void createProduct(@RequestParam("name") String name) {
        productService.createProduct(name);
    }

    @PostMapping("/change-activity")
    @ApiOperation(value = "Change status of product")
    public void changeActivity(@RequestParam("status") Boolean status,
                                @RequestParam("id") Long id) {
        productService.changeActivity(status, id);
    }

    @PostMapping("/add-quantity")
    @ApiOperation(value = "Add some quantity of product")
    public void addActivity(@RequestParam("quantity") Long quantity,
                               @RequestParam("id") Long id) {
        productService.addQuantity(quantity, id);
    }

    @PostMapping("/delete-quantity")
    @ApiOperation(value = "Remove part of quantity of product")
    public void deleteQuantity(@RequestParam("quantity") Long quantity,
                            @RequestParam("id") Long id) {
        productService.deleteQuantity(quantity, id);
    }
}
