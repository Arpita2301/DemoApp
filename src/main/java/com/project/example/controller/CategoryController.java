package com.project.example.controller;

import com.project.example.DTO.BrandDTO;
import com.project.example.DTO.CategoryDTO;
import com.project.example.DTO.SubjectDTO;
import com.project.example.entity.Brand;
import com.project.example.entity.Category;
import com.project.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @GetMapping(path = "/getCategory")
//    public Category getCategory(@RequestParam String cName){
//        return categoryService.getCategory(cName);
//    }

    @GetMapping(path = "/getCategory", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CategoryDTO getCategory(@RequestParam String cName){
        return categoryService.getCategory(cName);
    }
///get category
    @PostMapping(path = "/createCategory", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String createCategory(@RequestParam String c_id,
                                 @RequestParam String c_name
                                 ){
        categoryService.createCategory(c_id, c_name);
        return "Success!!!";
    }

    @PostMapping(path = "/createCategoryWithBrand", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String createCategoryWithBarnd(@RequestParam String cId,
                                          @RequestParam String cName,
                                          @RequestParam List<String> brandList){
        //create category with brand
        categoryService.createCategoryWithBarnd(cId, cName, brandList);

        return "Successfull!!!";

    }

    @PostMapping(path = "/updateCategoryName", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateCategoryName(@RequestBody CategoryDTO categoryDTO){
        categoryService.updateCategoryName(categoryDTO);
        return "Category Details Updated Successfully";
    }
}
