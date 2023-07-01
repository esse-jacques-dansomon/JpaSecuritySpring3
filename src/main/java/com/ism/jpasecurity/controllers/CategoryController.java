package com.ism.jpasecurity.controllers;


import com.ism.jpasecurity.entities.Category;
import com.ism.jpasecurity.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/gestion")
    public String gestion() {
        return "categorie.gestion";
    }

    @GetMapping("/liste")
    public String liste(Model model) {
        model.addAttribute("liste", categoryService.findAllCategories());
        return "categorie.liste";
    }

    @GetMapping("/add")
    public String ajout(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "categorie.ajout";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("category") Category category, BindingResult result){
        if(result.hasErrors()){
            return "categorie.ajout";
        }
        categoryService.saveCategory(category);
        return "redirect:/category/liste";
    }

    @GetMapping("/supprimer/{code}")
    public String delete(@PathVariable("code") String code){
        categoryService.deleteCategory(code);
        return "redirect:/category/liste";
    }

    @GetMapping("/modifier/{code}")
    public String modifier(@PathVariable("code") String code, Model model){
        Category category = categoryService.findCategory(code);
        if(category == null){
            return "redirect:/category/liste";
        }
        model.addAttribute("category", category);
        return "categorie.modifier";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("categorie") Category category, BindingResult result){
        if(result.hasErrors()){
            return "categorie.modifier";
        }
        categoryService.saveCategory(category);
        return "redirect:/category/liste";
    }

}
