package com.project.example.services;

import antlr.ASTNULLType;
import com.project.example.DTO.BrandDTO;
import com.project.example.DTO.CategoryDTO;
import com.project.example.DTO.ProductsDTO;
import com.project.example.controller.ProductsController;
import com.project.example.converter.CategoryConverter;
import com.project.example.converter.ProductsConverter;
import com.project.example.entity.Brand;
import com.project.example.entity.Category;
import com.project.example.entity.Products;
import com.project.example.entity.Subject;
import com.project.example.repository.BrandRepository;
import com.project.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;


//    public static List<Category> test(String p_id) {
//        return categoryRepository.findAll();
//    }

//    public Category getCategory(String categoryName) {
//
//       Category category =  categoryRepository.findByCName(categoryName);
//        return category;
//    }

    public CategoryDTO getCategory(String cName) {
        Category category = categoryRepository.findByCName(cName);
        return CategoryConverter.getCName(category);

    }
    public void createCategory(String cId, String cName){
        Category category = new Category();
        category.setCId(cId);
        category.setCName(cName);
        categoryRepository.save(category);
    }

    public void createCategoryWithBarnd(String cId, String cName, List<String> brandList) {
        Category category = new Category();
        category.setCId(cId);
        category.setCName(cName);
        List<Brand> brandList1 = new ArrayList<>();

        int i = 0;

        for (String brandId : brandList){
            Brand brand =  brandRepository.findByBrandId(brandId);
            brandList1.add(brand);
        }
        category.setBrand(brandList1);
        categoryRepository.save(category);
    }

    public void updateCategoryName(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findByCId(categoryDTO.getCId());

        if(category != null){
            category.setCName(categoryDTO.getCName());
            categoryRepository.save(category);
        }

    }
}
