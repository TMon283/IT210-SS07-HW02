package org.example.homework02ss07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/dish")
public class DishController {

    @ModelAttribute("categories")
    public List<String> populateCategories() {
        return Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish/add";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        return "dish/edit";
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("searchForm", new DishSearchForm());
        return "dish/search";
    }
}
