package com.almo.restaurant.controllers;

import com.almo.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class NavigationController {
    private final RestaurantController restaurantController;

    @GetMapping(value = "/resto")
    public String index(Model model) {
        //model.addAttribute("message-test", "Hi test offline Thymeleaf");
        return "index";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("restaurants", restaurantController.getAll());
        return "home";
    }

    @GetMapping("/all")
    public String getAllRestaurant(Model model) {
        model.addAttribute("restaurants", restaurantController.getAll());
        return "restaurants/all";
    }

    @GetMapping("/create")
    public String nouveauRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
        return "restaurants/create";
    }

    @PostMapping("/new")
    public String createRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
        restaurantController.create(restaurant);
        return "redirect:/all";
    }
}
