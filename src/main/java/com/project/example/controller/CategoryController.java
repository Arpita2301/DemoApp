package com.project.example.controller;

import com.project.example.DTO.BrandDTO;
import com.project.example.DTO.CategoryDTO;
import com.project.example.entity.Brand;
import com.project.example.entity.Category;
import com.project.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

//    @GetMapping(path = "/getCategory")
//    public Category getCategory(@RequestParam String cName){
//        return categoryService.getCategory(cName);
//    }

    @GetMapping(path = "/getCategory")
    public CategoryDTO getCategory(@RequestParam String cName){
        return categoryService.getCategory(cName);
    }

    @PostMapping(path = "/createCategory")
    public String createCategory(@RequestParam String c_id,
                                 @RequestParam String c_name
                                 ){
        categoryService.createCategory(c_id, c_name);
        return "Success!!!";
    }

    @PostMapping(path = "/createCategoryWithBrand")
    public String createCategoryWithBarnd(@RequestParam String cId,
                                          @RequestParam String cName,
                                          @RequestParam List<String> brandList){
        //create category with brand
        categoryService.createCategoryWithBarnd(cId, cName, brandList);

        return "Successfull!!!";

    }


}
