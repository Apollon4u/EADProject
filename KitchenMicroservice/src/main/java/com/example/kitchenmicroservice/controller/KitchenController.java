package com.example.kitchenmicroservice.controller;

import com.example.kitchenmicroservice.model.Kitchen;
import com.example.kitchenmicroservice.model.Product;
import com.example.kitchenmicroservice.service.KitchenService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
public class KitchenController {

    private final KitchenService kitchenService;

    @GetMapping("/get-by-id")
    @ApiOperation(value = "Get kitchen by id")
    public ResponseEntity<Kitchen> getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(kitchenService.getById(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new kitchen")
    public void createKitchen(@RequestBody Kitchen kitchen) {
        kitchenService.create(kitchen);
    }

    @GetMapping("/get-products")
    @ApiOperation(value = "Get products of kitchen")
    public List<Product> getProducts(@RequestParam("id") Long id) {
        return kitchenService.getProductsById(id);
    }

    @PostMapping("/get-all")
    @ApiOperation(value = "Add product to dish")
    public List<Kitchen> getKitchens() {
        return kitchenService.getAll();
    }
}
