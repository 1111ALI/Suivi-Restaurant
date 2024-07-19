package com.almo.restaurant.controllers;

import com.almo.restaurant.entity.Person;
import com.almo.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class NavigationController {
    private final RestaurantController restaurantController;
    private final PersonController personController;
    private final UploadedFileController uploadedFileController;

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

    //Traitement Utilisateurs

    @GetMapping("/allPersons")
    public String getAllPerson(Model model) {
        model.addAttribute("persons", personController.getAllPerson());
        return "persons/all-person";
    }

    @GetMapping("/createPerson")
    public String nouveauPerson(@ModelAttribute Person person, Model model) {

        return "persons/create-person";
    }

    @PostMapping("/newPersons")
    public String createPerson(@ModelAttribute Person person, Model model) {
        personController.create(person);
        return "redirect:/allPersons";
    }

    //Fin traitement utilisateurs


    // Debut de l'authentification
    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public String connection() {

        return "redirect:/home";
    }

    @GetMapping("/home-auth")
    public String home() {

        return "restaurants/home";
    }

    //Fin de l'authentification
    @GetMapping("/form")
    public String upload(Model model) {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        Map<String, String> reponse = new HashMap<>();
        reponse = uploadedFileController.saveFile(file);
        model.addAttribute("message", "File upload successfully");
        model.addAttribute("message", reponse);
        return "upload";
    }

}
