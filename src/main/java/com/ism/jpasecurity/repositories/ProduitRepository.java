package com.ism.jpasecurity.repositories;

import com.ism.jpasecurity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProduitRepository extends JpaRepository<Product,Integer>{
    public Product findByNumero(Integer numero);

    public List<Product> findProduitByCategoryCode(String code);
}
