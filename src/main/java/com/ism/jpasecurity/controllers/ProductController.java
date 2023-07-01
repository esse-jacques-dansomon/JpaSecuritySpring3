package com.ism.jpasecurity.controllers;

import com.ism.jpasecurity.entities.Category;
import com.ism.jpasecurity.entities.Product;
import com.ism.jpasecurity.services.CategoryService;
import com.ism.jpasecurity.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/gestion")
    public String gestion(){
        return "produit.gestion";
    }

    @GetMapping("/liste")
    public String liste(Model model){
        model.addAttribute("liste", productService.findAllProducts());
        return "produit.liste";
    }

    @GetMapping("/add")
    public String ajout(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "produit.ajout";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return "produit.ajout";
        }
        Category category = categoryService.findCategory(product.getCodeCat());
        product.setCategory(category);
        productService.saveProduct(product);
        return "redirect:/product/liste";
    }

    @GetMapping("/supprimer/{numero}")
    public String delete(@PathVariable("numero") Integer numero){
        productService.deleteProduct(numero);
        return "redirect:/product/liste";
    }

    @GetMapping("/modifier/{numero}")
    public String modifier(@PathVariable Integer numero, Model model){
        Product product = productService.findProduct(numero);
        if(product == null){
            return "redirect:/product/liste";
        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "produit.modifier";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("produit") Product product, BindingResult result){
        if(result.hasErrors()){
            return "produit.modifier";
        }
        Category category = categoryService.findCategory(product.getCodeCat());
        product.setCategory(category);
        productService.saveProduct(product);
        return "redirect:/product/liste";
    }

    //Get products by category code
    //The param is optional
    @PostMapping("/filtered")
    public String listeByCategory(@RequestParam("code") String code, Model model){
        model.addAttribute("categories", categoryService.findAllCategories());
        Category category = categoryService.findCategory(code);
        model.addAttribute("category", category.getLibelle());
        model.addAttribute("liste", productService.findProductsByCategoryCode(code));
        return "categorie.produits";
    }

    //Get products by category code
    //The param is optional
    @GetMapping("/filter")
    public String listeByCategoryForm(Model model){
        model.addAttribute("categories", categoryService.findAllCategories());
        return "produit.filter";
    }
}
