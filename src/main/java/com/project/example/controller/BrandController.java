package com.project.example.controller;

import com.project.example.DTO.BrandDTO;
import com.project.example.DTO.CategoryDTO;
import com.project.example.entity.Brand;
import com.project.example.entity.Student;
import com.project.example.entity.Subject;
import com.project.example.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")

public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping(path = "/createBrand", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String createBrand(@RequestParam String brandId,
                              @RequestParam String brandName) {
        //test comment
        //second comment
        brandService.createBrand(brandId, brandName);
        System.out.println("Brand Created Successfully");


        return "Success!!!";
    }
    @GetMapping(path = "/getAllBrands", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Brand> getAllBrands(){
        return brandService.getBrand();
    }

    @GetMapping(path = "/getBrandById", produces = { MediaType.APPLICATION_JSON_VALUE })
    public BrandDTO getBrandById(@RequestParam String brandId){

        return brandService.getBrandById(brandId);
    }

    @PostMapping(path = "/updateBrandName", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateBrandName(@RequestBody BrandDTO brandDTO){
        brandService.updateBrandName(brandDTO);
        return "Brand Details Updated Successfully";
    }
}