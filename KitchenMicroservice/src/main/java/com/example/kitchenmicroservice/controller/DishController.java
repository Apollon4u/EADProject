package com.example.kitchenmicroservice.controller;

import com.example.kitchenmicroservice.model.Dish;
import com.example.kitchenmicroservice.service.DishService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    @GetMapping("/get-by-id")
    @ApiOperation(value = "Get dish by id")
    public ResponseEntity<Dish> getDishById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(dishService.getDish(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new dish")
    public void createDish(@RequestBody Dish dish) {
        dishService.createDish(dish);
    }

    @GetMapping("/get-price")
    @ApiOperation(value = "Get price of dish")
    public ResponseEntity<Double> getPriceOfDish(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(dishService.getPrice(id));
    }

    @PostMapping("/add-product")
    @ApiOperation(value = "Add product to dish")
    public void addProduct(@RequestParam("id") Long dishId,
                           @RequestParam("id") Long productId) {
        dishService.addProduct(dishId, productId);
    }
}
