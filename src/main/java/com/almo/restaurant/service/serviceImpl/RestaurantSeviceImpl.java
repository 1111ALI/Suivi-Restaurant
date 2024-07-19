package com.almo.restaurant.service.serviceImpl;

import com.almo.restaurant.entity.Restaurant;
import com.almo.restaurant.repository.RestaurantRepository;
import com.almo.restaurant.service.serviceInterf.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantSeviceImpl implements RestaurantService {
    public final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant create(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {

        return restaurantRepository.findAll();
    }
}

