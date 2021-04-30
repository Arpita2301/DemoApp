package com.project.example.repository;

import com.project.example.entity.Category;
import com.project.example.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String> {

    @Query(value = "SELECT * FROM products where c_id = :#{#cId}" , nativeQuery = true)
    public List<Products> findByCId(String cId);

//
    @Query(value = "SELECT products.p_id, products.p_name, category.c_id, category.c_name\n" +
            "FROM products\n" +
            "INNER JOIN category\n" +
            "ON products.c_id=category.c_id\n" +
            "WHERE products.c_id = :#{#cId}" , nativeQuery = true)
    public Products findByPId(String cId);
}
