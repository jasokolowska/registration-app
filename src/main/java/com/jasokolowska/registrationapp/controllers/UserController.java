package com.jasokolowska.registrationapp.controllers;

import com.jasokolowska.registrationapp.model.User;
import com.jasokolowska.registrationapp.model.UserDto;
import com.jasokolowska.registrationapp.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private DbService dbService;

    @GetMapping({"/list", ""})
    public String getAllUsers(Model model) {

        model.addAttribute("users", dbService.getUsers());

        return "users/users-list";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {

        model.addAttribute("user", dbService.getUser(id));

        return "user";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "users/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        dbService.addUser(user);
        return "redirect:/users/list";
    }
}
