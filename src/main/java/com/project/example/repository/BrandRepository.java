package com.project.example.repository;

import com.project.example.entity.Brand;
import com.project.example.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    @Query(value = "SELECT * FROM brand where brand_id = :#{#brandId}" , nativeQuery = true)
    public Brand findByBrandId(String brandId);

}
