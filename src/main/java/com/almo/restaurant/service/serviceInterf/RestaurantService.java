package com.almo.restaurant.service.serviceInterf;

import com.almo.restaurant.entity.Restaurant;
import com.almo.restaurant.repository.RestaurantRepository;

import java.util.List;

public interface RestaurantService {
     Restaurant create(Restaurant restaurant);

    List<Restaurant> getAll();
}
