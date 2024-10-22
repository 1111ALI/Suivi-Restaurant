package com.almo.restaurant.controllers.frontEnd;

import com.almo.restaurant.controllers.api.PersonController;
import com.almo.restaurant.controllers.api.RestaurantController;
import com.almo.restaurant.controllers.api.UploadedFileController;
import com.almo.restaurant.controllers.api.UtilisateurController;
import com.almo.restaurant.dto.PersonDto;
import com.almo.restaurant.entity.Person;
import com.almo.restaurant.entity.Restaurant;
import com.almo.restaurant.entity.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class NavigationController {
    private final RestaurantController restaurantController;
    private final PersonController personController;
    private final UploadedFileController uploadedFileController;
    private final UtilisateurController utilisateurController;

    // Debut de l'authentification

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public String connected() {

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {

        return "home";
    }
    //Fin de l'authentification


    @GetMapping("/register")
    public String ouvrireRegister() {
        return "persons/register";

    }

    @GetMapping(value = "/resto")
    public String index(Model model) {
        //model.addAttribute("message-test", "Hi test offline Thymeleaf");
        return "index";
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

    @GetMapping("/allutilisateur")
    public String getAllUtilisateur(Model model) {
        model.addAttribute("utilisateurs", utilisateurController.getAllUtilisateur());
        return "persons/all-utilisateur";
    }

    @GetMapping("/registration")
    public String enregistrerUtilisateur(@ModelAttribute Utilisateur utilisateur, Model model) {
        return "persons/register";
    }

    @PostMapping("/nouveau")
    public String CreerUtilisateur(@ModelAttribute Utilisateur utilisateur, Model model) {
        utilisateurController.createUtilisateur(utilisateur);
        model.addAttribute("message", "Utilisateur enregistré avec success");
        return "redirect:/allutilisateur";
    }

    //Traitement Persons

    @GetMapping("/allPersons")
    public String getAllPerson(Model model) {
        model.addAttribute("persons", personController.getAllPerson());
        return "persons/all-person";
    }

    @GetMapping("/createPerson")
    public String nouveauPerson(@ModelAttribute PersonDto personDto, Model model) {

        return "persons/create-person";
    }

    @PostMapping("/newPersons")
    public String createPerson(@ModelAttribute PersonDto personDto, Model model) {
        personController.createPerson(personDto);
        model.addAttribute("message", "Utilisateur enregistré avec success");
        return "redirect:/allPersons";
    }

}
