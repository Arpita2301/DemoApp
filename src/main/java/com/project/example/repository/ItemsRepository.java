package com.project.example.repository;

import com.project.example.entity.Brand;
import com.project.example.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, String> {
    @Query(value = "SELECT * FROM items where item_id = :#{#itemId}" , nativeQuery = true)
    public Items findByItemId(String itemId);


}
