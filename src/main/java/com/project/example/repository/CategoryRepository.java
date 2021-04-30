package com.project.example.repository;

import com.project.example.entity.Category;
import com.project.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query(value = "SELECT * FROM category where c_id = :#{#cId}" , nativeQuery = true)
    public Category findByCId(String cId);

    @Query(value = "SELECT * FROM category where c_name = :#{#cName}" , nativeQuery = true)
    public Category findByCName(String cName);
}
