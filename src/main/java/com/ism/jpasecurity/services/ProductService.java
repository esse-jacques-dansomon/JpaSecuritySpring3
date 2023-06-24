package com.ism.jpasecurity.services;


import com.ism.jpasecurity.entities.Product;
import com.ism.jpasecurity.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProduitRepository produitRepo;

    @Transactional
    public void saveProduct(Product product){
        produitRepo.save(product);
    }

    @Transactional
    public void deleteProduct(Integer code){
       Optional<Product> produit = produitRepo.findById(code);
        if(produit.isPresent()){
            produitRepo.deleteById(code);
        }
    }

    public Product findProduct(Integer code){
        Optional<Product> produit = produitRepo.findById(code);
        return produit.orElse(null);
    }

    public List<Product> findAllProducts(){
        return produitRepo.findAll();
    }

    //Get products by category code
    public List<Product> findProductsByCategoryCode(String code){
        return produitRepo.findProduitByCategoryCode(code);
    }
}
