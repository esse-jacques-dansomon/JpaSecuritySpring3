package com.ism.jpasecurity.repositories;

import com.ism.jpasecurity.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieRepository extends JpaRepository<Category,String> {
    public Category findByCode(String code);
}
