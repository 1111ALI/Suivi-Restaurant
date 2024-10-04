package com.almo.restaurant.controllers.api;

import com.almo.restaurant.entity.Restaurant;
import com.almo.restaurant.service.serviceInterf.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {
    public final RestaurantService restaurantService;

    @PostMapping("/new")
    public Restaurant create(@RequestBody Restaurant restaurant) {

        return restaurantService.create(restaurant);
    }
    @GetMapping("/all")
    public List<Restaurant> getAll(){

        return restaurantService.getAll();
    }
}
