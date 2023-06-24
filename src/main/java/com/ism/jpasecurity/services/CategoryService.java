package com.ism.jpasecurity.services;

import com.ism.jpasecurity.entities.Category;
import com.ism.jpasecurity.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategorieRepository cateRepo;

    @Transactional
    public void saveCategory(Category category){
        cateRepo.save(category);
    }

    @Transactional
    public void deleteCategory(String code){
        //Recuperer la category
        Category category = cateRepo.findByCode(code);
        //Verifier si la category existe
        if(category != null){
            //Supprimer la category
            cateRepo.delete(category);
        }
    }

    public Category findCategory(String code){
        return cateRepo.findByCode(code);
    }

    public List<Category> findAllCategories(){
        return cateRepo.findAll();
    }
}
